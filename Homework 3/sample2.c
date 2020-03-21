// Sample two - click here to download the source 
#include <stdio.h>
main(void)
{
    int numPrinters = 10;
    int numPhones = 20, numDesks = 15;
    /*$print LOCAL*/
    /*$print k*/
    while(numPhones >= 0)
    {
        int numPrinters = 15;
	int i = 50;
	int j = 60;
    /*$print LOCAL*/
	if(numPrinters == 15)
	{
        i = j + numPrinters;   
        /*$print LOCAL*/
	    /*$print numPrinters*/
	    /*$print numPhones*/		
	    return 0;	
	}
	j = i + j;	/*No change here*/
    /*$print numPrinters*/
    }
    /*$print numPrinters*/
    return 0;
}
