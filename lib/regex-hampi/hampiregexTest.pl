#/usr/bin/perl -w
#
#
# Author : Devdatta Akhawe
# Code under MIT license 
use strict;
use lib '.';
use pcre_tohampi;
use Cwd 'chdir';

my $startdir=$ENV{'PWD'};
chdir('../..');
while(<>){
  chomp;
  my $regex=$_;
  #$regex=$1.$2 if( $regex =~ m/(\/.*?[^\\]\/[^\/g]*)g([^\/g]*)/);
  $regex=$1.$2 if( $regex =~ m/^(.*?)g([^\/]*)$/);
  $regex=eval 'qr'.$regex;
  my $p= pcre_tohampi->new($regex);
  $p->parse;
  my ($str,$min,$max)=$p->tothehampi();
  $min = 1 if $min==0;
  die "error calculating minimum for regex" if $min<0;
  open(HMP,'>','/tmp/foo.hmp') or die $!;
  print HMP "\nvar string:$min;\n$str\nassert string in flax0;\n";
  #print HMP "\n cfg printablechar := [\\032-\\126];\n cfg printabletext := (printablechar)*;\n assert string in printabletext;\n";
  close(HMP);
  open(RES,"./hampi.sh /tmp/foo.hmp |") or die $!;
  my $str="";
  $str.=$_ while(<RES>);
  close(RES);
  if($str =~ m/\n\{VAR\(string\)\=(.*?)\}$/s){
      die "Failure for $regex\n" if $1 !~ $regex;
      print "SUCCESS for $regex\n";
    } else {
      die "$regex : couldn't find a solution from hampi\n";
    }
}

chdir($startdir);
