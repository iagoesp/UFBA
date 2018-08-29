#include <bits/stdc++.h>

using namespace std;


typedef struct{
	int chave;
	string nome;
} reg;

int main(){
	FILE * arq;
	//w+ e w - criam o arquivo caso não exista; se existir, eles sobrescrevem
	//r+ e r - se não existir o arquivo prévio, retorna Falha de Segmentação
	arq = fopen("teste.dat", "w+");
	int chave = 1;
	string n = "caio";
	reg write;
	reg reader;
	write.chave = chave;
	write.nome = n;
	fwrite(&write, sizeof(write), 1, arq);
	fclose(arq);

	FILE * arqReader;
	arqReader = fopen("teste.dat", "r+");
	fseek(arqReader, sizeof(reader)*0, SEEK_SET);
	fread(&reader, sizeof(reader), 1, arqReader);
	cout<<reader.nome<<endl;
	fclose(arqReader);	
}
