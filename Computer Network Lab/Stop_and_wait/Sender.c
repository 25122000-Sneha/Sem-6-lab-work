#include <stdio.h>
#include <stdlib.h>
#include <string.h>
main()
{
	int i, n, ch;
	int one, a=0;
	char input[20], ackstring[20];
	FILE *in, *ack;
	while(1)
	{
		printf("\n\tStop and Wait protocol");
		printf("\n1. Send\n2. Check ack\n3. EOT");
		printf("\nEnter choice:");
		scanf("%d", &ch);
		switch(ch)
		{
			case 1:
				in = fopen("data.txt", "w");
				printf("\nEnter data:");
				scanf("%s", input);
				printf("%s", input);
				n = strlen(input);
				one = 0;
				fprintf(in, "%s", input);
				for(i=0; i<n+1; i++)
				{
					if(input[i] == '1')
					{
						one++;
					}
				}
				if(one%2==1)
				{
					fprintf(in, "%d", 1);
				}
				else
				{
					fprintf(in, "%d", 0);
				}
				a++;
				printf("\nData sent");
				break;
				
			case 2:
				ack = fopen("ack.txt", "r");
				fscanf(ack, "%s", ackstring);
				fclose(ack);
				if(atoi(ackstring) == a)
				{
					printf("\nData Acknowledged");
				}
				else
				{
					printf("\nData not acknowledged");
					a--;
				}
				break;
			
			case 3:
				printf("******Exit********");
				exit(0);
			default:
				printf("Invalid output");
		}
	}
}
