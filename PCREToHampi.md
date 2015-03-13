The subversion repository currently contains a perl script that can automatically convert most regular expressions to the Hampi grammar format. Please check out the code from svn. The instructions for using it are below.

### Requirements ###

The script should work on any reasonably new version of Perl 5. It was developed on a linux machine, but is also known to work on Mac.

### Usage ###

Usage is pretty simple, and is easiest to explain via a sample code block:
```
#use the current directory for library includes
# if you have the pcre_tohampi.pm and YAPE folder 
# somewhere else, change this accordingly
use lib '.'; 
use pcre_tohampi; # include the library

#create a object from the particular regular expression.
my $p=pcre_tohampi->new(qr/abc/);
$p->parse;
print $p->tothehampi('prefix');
```

The non-terminal _prefix\_flax0_ will match the whole regular expression. _prefix\_flax1_,_prefix\_flax2_ etc. are non terminals that match the nthcapturing groups inside the regular expression.

### Strings to Regex Object ###

Ofcourse, any practical usage would involve input which would be in the form of strings. Converting these strings to regular expressions is a little tricky. The following code can work :
```
my $str="/abc/";
my $regex=eval 'qr'.$str;
```

The problem is that, by default, qr with the forward slash as a delimiter interpolates. In particular, the @ character is considered start of an array. To circumvent this, you can escape the @ character by changing it to a \@.
```
my $str="/a@bc/";
$str=~ s/@/\\@/g;
my $regex=eval 'qr'.$str;
```

Another option is to use a different delimiter. In particular the single quote delimiter doesn't interpolate. Ofcourse, it has to be escaped before being used a delimiter. The following works :
```
//let input be the string a@bc
my $str=<INP>;
$str=~s/'/\'/g;
my $regex= eval 'qr'."'$str'";
```


For a more complete example see the hampiregexTest.pl file in the same directory. The hampiregexTest.pl script takes a list of regular expressions as input, converts them to Hampi's format, calls Hampi on it and then checks the result to see if it belongs to the input regular expression. For e.g, try running the following :
```
perl hampiregexTest.pl < sampleRegex
```

### Acknowledgements ###

Thanks to Jeff Pinyan for kindly agreeing to release his nice YAPE toolset in the MIT license. Thanks also to Stephen McCamant for a lot of help during coding this tool.