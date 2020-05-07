# MapFilter 2.0 Tutorial

## Configuração inicial

O sofware **MapFilter 2.0** processa dados númericos com separador decimal `.` (ponto). A configuração pode ser feita através do painel de controle:

Painel de controle > Relógio e Região > Alterar Formato de data, hora ou número > Configurações adicionais  

Em seguida altere os campos conforme abaixo:  

> Símbolo decimal: `.` (ponto)  
> Símbolo de agrupamento de dígitos: `,` (vírgula)  
> Separador de listas: `,` (vírgula)    


## Formato do arquivo de dados

O **MapFilter** processa um único conjunto de dados em um arquivo em formato de texto (`.txt` ou `.csv`) por vez. O arquivo de texto deve conter pelo menos *três atributos **numéricos_**: dois atributos contendo a **latitude** e **longitude** e o **atributo** que será submetido à filtragem.

### Importante

* A primeira linha do arquivo deve conter um cabeçalho (denominação) de atributos; 
* As coordenadas devem estar no datum WGS 84 fornecido em **coordenadas geográficas (graus decimais)**, que é uma forma comum para o armazenamento de coordenadas em registradores de dados agrícolas **ou** na forma **métrica (UTM)**; 
* As coordenadas precisam ter o cabeçalho nomeados com as iniciais **"Lat"** e **"Long"** ou **"X"** e **"Y"**.


## Filtragem dos dados

### Iniciar o software

Para iniciar o software **MapFilter 2.0** é só clicar no Menu Iniciar do Window. Em seguida ir na pasta **LAP USP** e clicar em **MapFilter**.  
  
  
  
<p align="center">
     <a href="#"><img src="https://github.com/LeonardoTche/MapFilter2.0/blob/master/Tutorial/Img/telaIinicial.png" width="700"/></a>          <br>  
  <em> Interface inicial </em>
</p> 



### Selecionar arquivo

Neste tutorial iremos utilizar como exemplo dados de produtivade de milho. 

Para abrir o conjunto de dados a ser filtrado clique em  [![image](https://github.com/LeonardoTche/MapFilter2.0/blob/master/Tutorial/Img/img2.png?raw="True")](#features) na tela inicial e selecione o arquivo [`corn_yield.txt`](/Exemplo/).


### Identificar o atributo a ser filtrado

Identifique o atributo a ser filtrado:

<p align="center">
     <a href="#"><img src="https://github.com/LeonardoTche/MapFilter2.0/blob/master/Tutorial/Img/img3.png" width="300"/></a> 
</p> 


Os dados do atributo a ser filtrado são plotados no visor e a estatística descritiva é calculada:

<p align="center">
     <a href="#"><img src="https://github.com/LeonardoTche/MapFilter2.0/blob/master/Tutorial/Img/img4.png" width="700"/></a> 
</p>



### Filtragem global

O filtro global foi adicionado antes do filtro local para evitar a inflação de variações dos valores do atributo na análise local devido a valores muito baixos ou muito altos. No filtro global, a mediana dos valores do atributo em análise é usado para calcular os limites de corte superior (Eq. 1) e inferior (Eq. 2):
```
Limite Superior = mediana + mediana x v                                                                  Equação 1
Limite Inferior = mediana - mediana x v                                                                  Equação 2
```
O valor de ` v ` deve ser informado pelo usuário no campo | [![image](https://github.com/LeonardoTche/MapFilter2.0/blob/master/Tutorial/Img/img6.png?raw="True")](#)  

No nosso exemplo iremos utilizar ` v = 90 `. 


Para realizar a filtragem global bansta clicar em|  <a href="#"><img src="https://github.com/LeonardoTche/MapFilter2.0/blob/master/Tutorial/Img/img7.png?raw=True"></a>
:--|:--
