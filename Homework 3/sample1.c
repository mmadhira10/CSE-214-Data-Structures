// Sample one - click here to download the source 
#include <stdio.h>
main(void)
{
    int i = 0;
    int j = 2, k = 3, n;
    int m;	         /*Default value of zero*/
    k = 20 + i;	     /*Doesn't affect the initial value*/
    /*$print LOCAL*/
    /*$print k*/
    j = 10 + k;	     /*Doesn't affect the initial value*/
    i++;	         /*Neither does this*/
    if(k >= 0)
    {
        int i = 15;
        k = i;    	 /*Doesn't affect the initial value*/
        i++;	     /*Doesn't affect the initial value*/
        /*$print LOCAL*/
	/*$print i*/
	/*$print j*/
    }
    return 0;
}
