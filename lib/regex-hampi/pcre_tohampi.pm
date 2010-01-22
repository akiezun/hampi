package pcre_tohampi::Element;
package pcre_tohampi;

# To do .. flags like case insensitive matching etc.

use strict;
use YAPE::Regex 'pcre_tohampi';

my $case="";
my $counter=0;
my $capturenum=0;
my @array=();
my %casehash=();
my %minhash=();
my %maxhash=();
my $valid_POSIX = qr{
  alpha | alnum | ascii | cntrl | digit | graph |
  lower | print | punct | space | upper | word | xdigit
}x;

my %exp = (
  # macros
  # Don't tell me \096 - \096 is stupid .. I know .. but I am lazy
  '\w' => '[\065 - \090] | [\097 - \122] | [\048 - \057] | [\095 - \095]' ,#word characters (a-z, A-Z, 0-9, _)',
  '\W' => '[\000 - \047] | [\058 - \064] | [\091 - \094] | [\096 - \096] | [\123 - \255]' ,#'non-word characters (all but a-z, A-Z, 0-9, _)',
  '\d' => '[\048 - \057]', #'digits (0-9)',
  '\D' => '[\000 - \047] | [\058 - \255]' , #'non-digits (all but 0-9)',
  '\s' => '[\009 - \009] | [\032 - \032]',# (\n, \r, \t, \f, and " ")',
  '\S' => '[\000 - \008] | [\010 - \031] | [\033 - \255]', #non-whitespace (all but \n, \r, \t, \f, and " ")',
  '.' => '[\032 - \126]',
);

my %slashhash = (
  '\n'=> "\n",
  '\t' => "\t",
  '\r' => "\r",
  "\\\\" => "\\",
  '\[' => "\[",
  '\(' => "\(",
  '\.' => "\.",
  '\{' => "\{",
  '\*' => "\*",
  '\+' => "\+",
  '\?' => "\?",
  '\}' => "\}",
);



my $cc_REx = qr{(
  \\[0-3][0-7]{2} |
  \\x[a-fA-F0-9]{2} |
  \\x\{[a-fA-F0-9]+\} |
  \\c. |
  \\[nrftbae] |
  \\N\{([^\}]+)\} |
  \\[wWdDsS] |
  \\([Pp])([A-Za-z]|\{[^\}]+\}) |
  \[:(\^?)($valid_POSIX):\] |
  \\?.
)}xs;


sub numToHampi {
	my $num=shift;
	my $str=$num;
	$str="0$str" if $num < 100;
	$str="0$str" if $num < 10;
	return "\\$str";
} 		

sub charToHampi{
	my $char=shift;
	return numToHampi(ord($char));
}


sub getNT{
	$counter++;
	return "q$counter";
}

sub addRule{
	my ($nt,$quant,@rhsarr) = @_;
    	my $l = scalar @rhsarr;
    #print "\n\t\t length $l,$nt RHS is  @rhsarr";
    	my $max=0;
    	my $min=-1;
	my $out="";
	#print "for $nt the quantifier is $quant";
	for my $rhs (@rhsarr){
        $rhs =~ s/^\s+//;
		$out.=" | " if $out;
		$out.="$rhs";
        my ($tmin,$tmax)=(0,0);
        my $fchar = substr($rhs,0,1);
        my $count="blahblah";
        $count=1 if $fchar eq "[";
        $count = ($rhs=~ tr/\\//) if ($fchar eq "\\");
         if ($fchar eq "q" || $fchar eq "f" || $fchar eq "a"){
           $count=1;
          for my $qkey ( $rhs =~ m/flax\d+|q\d+|alpha[a-z]/g){
            die "$qkey not found " if ! exists $minhash{$qkey};
            $tmin+=$minhash{$qkey};
            $tmax=-1 if $maxhash{$qkey}==-1;
            next if $tmax==-1;
            $tmax+=$maxhash{$qkey};
          }
        }else { ($tmin,$tmax)=($count,$count)}

        die " eh what is this :$rhs " if $count eq "blahblah"; 
        $min = $tmin if ( ($min > $tmin) || $min==-1);
        $max = $tmax if (($max < $tmax && $max!=-1)||$tmax==-1);
        
	}
    #print "max : $max min : $min";
	my $rule="cfg $nt := $out;";
    $maxhash{$nt}=$max;
    $minhash{$nt}=$min;
	push @array,$rule;
	#print STDERR "$rule\n";
	my $newnt=$nt;
	if ( $quant eq "+" or $quant eq "*" or $quant eq "?" ){
		$newnt=getNT();
		#my $extrarule="cfg $newnt := $nt $newnt | $nt ;";
		my $extrarule="cfg $newnt := ($nt)$quant;";
		push @array,$extrarule;
        $min = 0 if ($quant eq "*" || $quant eq "?");
        $max = -1 if ($quant eq "*" || $quant eq "+");
        $maxhash{$newnt}=$max;
        $minhash{$newnt}=$min;
		#print STDERR "$extrarule\n";
	}
	
	if ( $quant =~ /\{(\d+),\}/){
		my $n1 = $1;
		my $tempnt = getNT();
		$newnt = getNT();
		my $extrarule="cfg $newnt := "."$nt "x $n1."$tempnt;";
		push @array,$extrarule;
		$extrarule="cfg $tempnt := ($nt)* ; ";
		push @array,$extrarule;
        $minhash{$newnt} = $min * $n1;
        $maxhash{$newnt} = -1;
	}
	if ( $quant =~ /\{(\d+),(\d+)\}/){
		my ($n1,$n2)=($1,$2);
		die "quantifier messed up first quantifier should be less than the second " if $n2 < $n1;
		my @rulearr=();
		push @rulearr,"$nt " x $_ for ($n1..$n2);
		my $extrarule = join "| ",@rulearr;
		$newnt = getNT();
		$extrarule="cfg $newnt := $extrarule;";	
		#print STDERR "$extrarule\n";
		push @array,$extrarule;
        $minhash{$newnt}=$min*$n1;
        $maxhash{$newnt}=$max*$n2;
				
	}
	
	if ( $quant =~ /\{(\d*)\}/ ){
        my $n = $1;
		my $extrarule = "$nt " x $n;
		$newnt = getNT();
		$extrarule = "cfg $newnt := $extrarule;";
		push @array,$extrarule;
        $minhash{$newnt}=$min*$n;
        $maxhash{$newnt}=$max*$n;
		#print STDERR "$extrarule\n";
		
	}
		
	
	if ( $newnt eq $nt and $quant ){
		die "\nunsupported quantifier $quant\n";
	}
	
	return $newnt;
}	
	

sub pcre_tohampi::anchor::tohampi { die "Can't handle anchor\n";}
sub pcre_tohampi::macro::tohampi { 
	my $self=shift;	
	return addRule(getNT(),$self->quant,$exp{$self->text});
	
	}
sub pcre_tohampi::oct::tohampi { die "oct unsupported"; }
sub pcre_tohampi::hex::tohampi { die "hex unsupported" ; } 
sub pcre_tohampi::utf8hex::tohampi { die "utf8hex unsupported" ; }
sub pcre_tohampi::ctrl::tohampi { die "ctrl characters unsupported" ; }
sub pcre_tohampi::named::tohampi { die "named expressions unsupported";}
sub pcre_tohampi::Cchar::tohampi { die "cchars unsupported";}
sub pcre_tohampi::slash::tohampi { 
	my $self=shift;
	my $nt=getNT();
	my $str=$self->text;
	#bug bug bug .. security big stinking hole .. god save me
	$str = $slashhash{$str} || die "couldn't find $str in table";
	#print STDERR "slash string is $str";
	$str=charToHampi($str);
	return addRule($nt,$self->quant,$str);
	}
	
	
sub pcre_tohampi::any::tohampi { 
	my $self=shift;
	return addRule(getNT(),$self->quant,$exp{"."});
	}
sub pcre_tohampi::text::tohampi { 
	my $self=shift;
	my $nt=getNT();
	my $rhs="";
	if($case){
	#	print "\n\tinside text and case\n";
		my $str=lc($self->text);
		for my $char (split(//,$str)){
			my $asc=ord($char);
	#		print "asc is $asc\n";
			if($asc<97 || $asc>120){
				$rhs.=" ".charToHampi($char);
			}else{
				$rhs.=" alpha$char";
				$minhash{"alpha$char"}=1;
				$maxhash{"alpha$char"}=1;
				$casehash{$char}="yes";
			}
		}
	#	print "\n\tending case: rule is $rhs";
	} else {
	$rhs = join " ",(map {numToHampi($_);} unpack("C*",$self->text));
	}
	#addRule($nt,$self->quant,$rhs);
	#print "wrote rule for ".$self->text."\n";
	return addRule($nt,$self->quant,$rhs);	
	
	}
sub pcre_tohampi::alt::tohampi { die " Can't handle alt\n"; }
sub pcre_tohampi::backref::tohampi { die "Can't handle backref\n";}
sub pcre_tohampi::class::tohampi {
	my $self=shift;
	my $class=$self->{TEXT};
	$class = $self->text if $self->{NEG} =~ /[pP]/;
	my $neg= ($self->{NEG} eq '^') ? 1: 0;
	my @numarr=();
	while ($class =~ s/^$cc_REx//) {
		my ($c1, $name, $pP, $utf8, $neg, $posix) = ($1,$2,$3,$4,$5,$6);
		if($utf8 or $posix){ die "don't know what to do here \n"; }
		if ($c1 !~ /\\[wWdDsS]/ and $class =~ s/^-$cc_REx//) {
				my ($c2, $name, $pP, $utf8, $neg, $posix) = ($1,$2,$3,$4,$5,$6);
				#print "The class $c1-$c2\n";
				push @numarr,$_ for(ord($c1)..ord($c2));
			} else {
				if ($c1 =~ /\\[wWdDsS]/){
					my $hampistring = $exp{$c1};
					while($hampistring =~ m/\[\\(\d{3})\s*-\s*\\(\d{3})\]/g){
						my ($n1,$n2) = ($1,$2);
						$n1 = $n1 + 0;
						$n2 = $n2 + 0;
						push @numarr,$n1..$n2;
					}
				}else {
				  $c1=$slashhash{$c1} if ( length $c1 == 2);
                  die "error : $c1 is not a character " if (length $c1 != 1);
			  	  push @numarr,ord($c1);
                }
				#print "just the char $c1 and value\n".ord($c1);
			} 
           
		}
#		print "c1 : $c1\t$name\t$pP\t$utf8\t$neg\t$posix\n";

	if($case){
	my @tmparr=();
	for my $charr (@numarr){
		push @tmparr,$charr+32 if($charr >=65 && $charr<=90);
		push @tmparr,$charr-32 if($charr >=97 && $charr<=122);
	}
	push @numarr,@tmparr;
	}
	
	if($neg){
		my %hash=();
		$hash{$_}=1 for(0...255);
		
		delete $hash{$_} for @numarr;
		@numarr=();
		push @numarr,$_ for (keys %hash);
	}
	my %seen ;
	$seen{$_}=1 for @numarr;
	@numarr= keys %seen;
	
	@numarr= sort {$a <=> $b} @numarr;
	my @rhsar=();
	my $start=shift @numarr;
	my $current=$start;
	for my $elem (@numarr){
		if ($elem == $current +1) {$current++; next;} ;
		my $rule=numToHampi($start);
		$rule="[$rule - ".numToHampi($current)."]" if ($current!=$start);
		push @rhsar ,$rule;
		$current=$elem;
		$start=$elem;
	}
	
      	my $rule=numToHampi($start);
      	$rule="[$rule - ".numToHampi($current)."]" if ($current!=$start);
      	push @rhsar,$rule;

	return addRule(getNT(),$self->quant,@rhsar);


	}
	

sub pcre_tohampi::comment::tohampi { die "can't handle comment\n"; }
sub pcre_tohampi::whitespace::tohampi { die "can't handle whitespace in regex \n";}
sub pcre_tohampi::flags::tohampi { die "can't handle flags \n";}
sub pcre_tohampi::code::tohampi { die "can't handle code\n"; }
sub pcre_tohampi::later::tohampi { die "can't handle later \n"; }
sub pcre_tohampi::capture::tohampi {
	# this is a non capturing group
	my $self=shift; 
	$capturenum++;
	my $nt = "flax$capturenum";
	
	my @rhsarr=();
	my $rhs="";
	#my @childarr=@{$self->{CONTENT}};
	#print $self->string; 
	for my $child (@{$self->{CONTENT}}){
		if($child->type eq "alt"){
			die "found an alt but there was no previous choice" if $rhs eq "";
			push @rhsarr,$rhs;
			$rhs="";
			next;
		}
		
		next if($child->type eq "anchor");
		
		
		my $othernt = $child->tohampi;
		$rhs.=" $othernt";
			
	}
	
	push @rhsarr,$rhs if $rhs;
	return addRule($nt,$self->quant,@rhsarr);
	#now using the 
	
}


sub pcre_tohampi::group::tohampi { 
	my $self=shift; 
	my $nt = getNT();
	
	my @rhsarr=();
	my $rhs="";
	#my @childarr=@{$self->{CONTENT}};
	#print $self->string; 
	for my $child (@{$self->{CONTENT}}){
		if($child->type eq "alt"){
			die "found an alt but there was no previous choice " if $rhs eq "";
			push @rhsarr,$rhs;
			$rhs="";
			next;
		}
		
		next if($child->type eq "anchor");
		
		
		my $othernt = $child->tohampi;
		$rhs.=" $othernt";
			
	}
	
	push @rhsarr,$rhs if $rhs;
	return addRule($nt,$self->quant,@rhsarr);
	
	
	}
sub pcre_tohampi::cut::tohampi { die " Can't handle cut \n"; }
sub pcre_tohampi::lookahead::tohampi { die "Can't handle lookahead\n"; }
sub pcre_tohampi::lookbehind::tohampi { die "Can't handle lookbehind\n"; }
sub pcre_tohampi::conditional::tohampi { die "Can't handle conditionals\n"; }

sub tothehampi{
	my $self=shift;
	
	my @nodes=@{ $self->{TREE} };
	my $regex=$self->display();
	$case="";
	$case = "yes" if $regex =~ m/\([^-]*i-/;
	$counter=0;
	$capturenum=0;
	@array=();
	%minhash=();
	%maxhash=();
	%casehash=();

	for my $node (@nodes){
		my $finalrule=$node->tohampi();
		
		my $rule = "cfg flax0 := $finalrule;\n";
		push @array,$rule;
		if($case){
			for my $char (keys %casehash){
				push @array,"cfg alpha$char := ".charToHampi($char)." | ".charToHampi(uc($char)).";";
			}
		}			
        return (join("\n",@array),$minhash{$finalrule},$maxhash{$finalrule});
#		printAllRules();
		
		#aaaaaaaaaaaaaaaargh
		
	}
}
1;
