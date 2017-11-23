#include <iostream>
#include <glm/glm.hpp>
#include <fstream>
#include <string>
#include <vector>
#include <math.h>
#include <csignal>
#include <cstdlib>


using namespace std;

int main () {
	int num=0, auxnum, cont=0, tam;
    float iso=0.0;
    float Pi, Pj, Pk;
    float fdiv(int v1, int v2);
    float divP1(int v2, float iso, float div);
    float divP2(int v1, float iso, float div);

    float CalcP(int v1, int v2, float iso, int w);

    float CalcXj(int aresta, int j);
    float CalcXk(int aresta, int k);

    float CalcYi(int aresta, int i);
    float CalcYk( int aresta, int k);

    float CalcZi(int aresta, int i);
    float CalcZj(int aresta, int j);

	vector<int> mem;
	vector<int> faces;
	vector<float> vertices;
	vector <int> configs[256];
	configs[256].clear();
    vector<float> matriz;
	string line, aux="";
	ifstream myfile ("example.txt");
    cout<<"Reading.."<<endl;
	if ( myfile.is_open() ){
		while (! myfile.eof() ){
			for(int i=0;i<256;i++){
				getline (myfile,line);
				for(int j=0;j<line.size();j++){
					if(line[j]=='-'){
						j+=2;
					}
					else if(line[j]==' ') {
						if(aux.size()==1) {
							num=aux[0]-48;
						}
						else if(aux.size()==2){
							for(int k=0;k<aux.size();k++){
                                    if(k==0){
                                        num=(aux[k]-48)*10;
                                    }
                                    else
                                        num+=(aux[k]-48);							}
						}
						configs[i].push_back(num);
						aux="";
					}
					else{
						aux+=line[j];
					}
				}
			}
			getline (myfile,line);
			aux=line[0];
			num=aux[0]-48;
			tam=(int)(pow(num,2));
			for(int i=0;i<num*num;i++){
				getline (myfile,line);
				for(int l=0;l<line.size();l++){
					aux=line[l];
					if(aux[0]!=' ') {
						auxnum=aux[0]-48;
						mem.push_back(auxnum);
						cont++;
					}
				}
			}
			getline (myfile,line);
			int dot=0;
			bool bdot=false;
			for(int l=0;l<line.size();l++){
				aux=line[l];
				for(int m=0;m<aux.size();m++){
					if(bdot){
						dot++;
					}
					if(aux[m]=='.'){
						bdot=true;
					}
					else if(aux[m]!='.') {
						auxnum=aux[m]-48;
						iso+=(float)(auxnum/(pow(10,dot)));
					}
				}
			}
		}
		myfile.close();
	}
	else cout << "Unable to open file";
    int matriz3[num][num][num];
    float vet0, vet1, vet2, vet3, vet4, vet5, vet6, vet7;
    cont=0;
    for(int i=0;i<num;i++){
        for(int j=0;j<num;j++){
            for(int k=0;k<num;k++){
                matriz3[i][j][k]=mem[i+j+k+cont];
            }
            cont+=num-1;
        }
        cont+=num-1;
    }
    int numconfig=0;
    for(int i=0;i<(int)tam/2 && i<num-1;i++){
        for(int j=0;j<(int)tam/2 && j<num-1;j++){
            for(int k=0;k<(int)tam/2 && k<num-1;k++){
                vet0 = matriz3[i][j+1][k];//ok
                vet1 = matriz3[i+1][j+1][k];//ok
                vet2 = matriz3[i+1][j+1][k+1];//ok
                vet3 = matriz3[i][j+1][k+1];//ok
                vet4 = matriz3[i][j][k];//ok
                vet5 = matriz3[i+1][j][k];//ok
                vet6 = matriz3[i+1][j][k+1];//ok
                vet7 = matriz3[i][j][k+1];//ok
                if(vet0>0){               //0 - p2
                   numconfig+=pow(2,0);   //0ok
                }
                if(vet1>0){
                    numconfig+=pow(2,1);
                }     //1ok
                if(vet2>0){
                    numconfig+=pow(2,2);
                }    //2ok
                if(vet3>0){
                    numconfig+=pow(2,3);
                }    //3ok
                if(vet4>0){
                    numconfig+=pow(2,4);
                }   //4ok
                if(vet5>0){
                    numconfig+=pow(2,5);
                }    //5ok
                if(vet6>0){
                    numconfig+=pow(2,6);
                }    //6ok
                if(vet7>0){
                    numconfig+=pow(2,7);
                }    //7ok
                for(int l=0; l < configs[numconfig].size() ; l++){
                    faces.push_back(configs[numconfig][l]);
                    if(configs[numconfig][l]==0){
                        Pi = CalcP(vet1, vet0, iso, i+1);
                        Pj = j+1;
                        Pk = k;
                        vertices.push_back(Pi);
                        vertices.push_back(Pj);
                        vertices.push_back(Pk);
                    }
                    else if(configs[numconfig][l]==1){
                        Pi = i+1;
                        Pj = j+1;
                        Pk = CalcP(vet2, vet1, iso, k+1);
                        vertices.push_back(Pi);
                        vertices.push_back(Pj);
                        vertices.push_back(Pk);
                    }
                    else if(configs[numconfig][l]==2){
                        Pi = CalcP(vet2, vet3, iso, i+1);
                        Pj = j+1;
                        Pk = k+1;
                        vertices.push_back(Pi);
                        vertices.push_back(Pj);
                        vertices.push_back(Pk);
                    }
                    else if(configs[numconfig][l]==3){
                        Pi = i;
                        Pj = j+1;
                        Pk = CalcP(vet3, vet0, iso, k+1);
                        vertices.push_back(Pi);
                        vertices.push_back(Pj);
                        vertices.push_back(Pk);
                    }
                    else if(configs[numconfig][l]==4){
                        Pi = CalcP(vet5, vet4, iso, i+1);
                        Pj = j;
                        Pk = k;
                        vertices.push_back(Pi);
                        vertices.push_back(Pj);
                        vertices.push_back(Pk);
                    }
                    else if(configs[numconfig][l]==5){
                        Pi = i+1;
                        Pj = j;
                        Pk = CalcP(vet6, vet5, iso, k+1);
                        vertices.push_back(Pi);
                        vertices.push_back(Pj);
                        vertices.push_back(Pk);
                    }
                    else if(configs[numconfig][l]==6){
                        Pi = CalcP(vet6, vet7, iso, i+1);
                        Pj = j;
                        Pk = k+1;
                        vertices.push_back(Pi);
                        vertices.push_back(Pj);
                        vertices.push_back(Pk);
                    }
                    else if(configs[numconfig][l]==7){
                        Pi = i;
                        Pj = j;
                        Pk = CalcP(vet4, vet7, iso, k+1);
                        vertices.push_back(Pi);
                        vertices.push_back(Pj);
                        vertices.push_back(Pk);
                    }
                    else if(configs[numconfig][l]==8){
                        Pi = i;
                        Pj = CalcP(vet0, vet4, iso, j+1);
                        Pk = k;
                        vertices.push_back(Pi);
                        vertices.push_back(Pj);
                        vertices.push_back(Pk);
                    }
                    else if(configs[numconfig][l]==9){
                        Pi = i+1;
                        Pj = CalcP(vet1, vet5, iso, j+1);
                        Pk = k;
                        vertices.push_back(Pi);
                        vertices.push_back(Pj);
                        vertices.push_back(Pk);
                    }
                    else if(configs[numconfig][l]==10){
                        Pi = i+1;
                        Pj = CalcP(vet2, vet6, iso, j+1);
                        Pk = k+1;
                        vertices.push_back(Pi);
                        vertices.push_back(Pj);
                        vertices.push_back(Pk);
                    }
                    else if(configs[numconfig][l]==11){
                        Pi = i;
                        Pj = CalcP(vet3, vet7, iso, j+1);
                        Pk = k+1;
                        vertices.push_back(Pi);
                        vertices.push_back(Pj);
                        vertices.push_back(Pk);
                    }
                }
                numconfig=0;
            }
        }
    }
    ofstream outFile;
    outFile.open("malha.obj");
    if(!outFile){
        cout<<"Erro em malha.obj"<<endl;
        abort();
    }
    cont=0;
    for(int i=0;i<vertices.size();i++){
        if(cont==0)
            outFile << "v ";
        outFile <<vertices[i]<<" ";
        cont++;
        if(cont==3){
            outFile <<endl;
            cont=0;
        }
    }
    for(int i=0;i<faces.size();i++){
        if(cont==0)
            outFile << "f ";
        outFile <<(i+1)<<" ";
        cont++;
        if(cont==3){
            outFile << endl;
            cont=0;
        }
    }
    outFile.close();
    cout<<"Done!"<<endl;
    return 0;
}
    float divP1(int v2, float iso, float div){
        return abs(iso-(float)v2)/div;
    }
    float divP2(int v1, float iso, float div){
        return abs(iso-(float)v1)/div;
    }
    float fdiv(int v1, int v2){
        return abs((float)v2-(float)v1);
    }

    float CalcP(int v1, int v2, float iso, int w){//1
        float div=fdiv((float)v1,(float)v2);
        float P = (float)w*divP1((float)v2,iso, div)+(float)(w-1)*divP2((float)v1, iso, div);
        return P;
    }
    float CalcXj(int aresta, int j){//1
        float Pj;
        if(aresta==0 || aresta==2){
            Pj=j+1;
        }
        else if(aresta==4 || aresta==6){
            Pj=j;
        }
        return Pj;
    }
    float CalcXk(int aresta, int k){//1
        float Pk;
        if(aresta==0 || aresta==4){
            Pk=k;
        }
        else if(aresta==2 || aresta==6){
            Pk=k+1;
        }
        return Pk;
    }

    float CalcYi(int aresta, int i){//1
        float Pi;
        if(aresta==8 || aresta==11){
            Pi=i;
        }
        else if(aresta==9 || aresta==10){
            Pi=i+1;
        }
        return Pi;
    }
    float CalcYk(int aresta, int k){//1
        float Pk;
        if(aresta==8 || aresta==9){
            Pk=k;
        }
        else if(aresta==10 || aresta==11){
            Pk=k+1;
        }
        return Pk;
    }

    float CalcZi(int aresta, int i){//1
        float Pi;
        if(aresta==1 || aresta==5){
            Pi=i+1;
        }
        else if(aresta==3 || aresta==7){
            Pi=i;
        }
        return Pi;
    }
    float CalcZj(int aresta, int j){//1
        float Pj;
        if(aresta==1 || aresta ==3){
            Pj=j+1;
        }
        else if(aresta==5 || aresta==7){
            Pj = j;
        }
        return Pj;
    }

