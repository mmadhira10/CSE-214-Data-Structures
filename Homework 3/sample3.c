// Sample three- click here to download the source 
#include <stdio.h>
main(void)
{
    int i, j = 2, k = 3;
	/*$print LOCAL*/
	/*$print k*/
    if(k >= 0)
    {
        int x = 15;
        k = x;
        x++;
		/*$print LOCAL*/
		/*$print i*/
		/*$print j*/
    }
    { int i=5; /*$print LOCAL*/ k = i;}
    return 0;
}
