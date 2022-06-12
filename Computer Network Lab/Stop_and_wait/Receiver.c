#include <stdio.h>
#include <stdlib.h>
#include <string.h>
main()
{
	int i, n;
	int one=0, a=0;
	char output[20];
	FILE *ack, *out;
	out = fopen("data.txt", "r");
	fscanf(out, "%s", output);
	n = strlen(output);
	for(i=0; i<n; i++)
	{
		if(output[i] == '1')
		{
			one++;
		}
	}
	if(one%2==0)
	{
		printf("\nReceived data has even parity.");
		printf("\nData accepted.....");
		a++;
		ack = fopen("ack.txt", "w");
		fprintf(ack, "%d", a);
		fclose(ack);
	}
	else
	{
		printf("\nReceived data has odd parity.");
		printf("\nData rejected.....");
		ack = fopen("ack.txt", "w");
		fprintf(ack, "%d", a);
	}
	printf("\nReceived data : ");
	for(i=0; i<n-1; i++)
	{
		printf("%c", output[i]);
	}
	fclose(out);
}
