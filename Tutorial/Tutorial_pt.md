# MapFilter 2.0 Tutorial

## Configuração inicial

O sofware **MapFilter 2.0** processa dados númericos com separador decimal `.` (ponto). A configuração pode ser feita através do painel de controle:

Painel de controle > Relógio e Região > Alterar Formato de data, hora ou número > Configurações adicionais  

Em seguida altere os campos conforme abaixo:  

> Símbolo decimal: `.` (ponto)  
> Símbolo de agrupamento de dígitos: `,` (vírgula)  
> Separador de listas: `,` (vírgula)    


## Formato do arquivo de dados

O **MapFilter** processa um único conjunto de dados em um arquivo em formato de texto (`.txt` ou `.csv`) por vez. O arquivo de texto deve conter pelo menos *três atributos numéricos*: dois atributos contendo a **latitude** e **longitude** e o **atributo** que será submetido à filtragem.

### Importante

* A primeira linha do arquivo deve conter um cabeçalho (denominação) de atributos; 
* As coordenadas devem estar no datum WGS 84 fornecido em **coordenadas geográficas (graus decimais)**, que é uma forma comum para o armazenamento de coordenadas em registradores de dados agrícolas **ou** na forma **métrica (UTM)**; 
* As coordenadas precisam ter o cabeçalho nomeados com as iniciais **"Lat"** e **"Long"** ou **"X"** e **"Y"**.


## Filtragem de dados

### Iniciar o software

Para iniciar o software **MapFilter 2.0** é só clicar no Menu Iniciar do Window. Em seguida ir na pasta **LAP USP** e clicar em **MapFilter**.  
  
  
  
<p align="center">
     <a href="#"><img src="https://github.com/LeonardoTche/MapFilter2.0/blob/master/Tutorial/Img/telaIinicial.png" width="700"/></a> <br/>  Interface inicial 
</p> 



### Selecionar arquivo

Neste tutorial iremos utilizar como exemplo dados de produtivade de milho. 

Para abrir o arquivo com os dados de produtividade de milho clique em  [![image](https://github.com/LeonardoTche/MapFilter2.0/blob/master/Tutorial/Img/img2.png?raw="True")](#features) na tela inicial e selecione o arquivo  [`corn_yield.txt`](/Exemplo/).


### Identificar o atributo a ser filtrado

Identifique o atributo a ser filtrado:



<img src="https://user-images.githubusercontent.com/35964306/81243340-f2158200-8fe5-11ea-9e1b-d94e184f42f0.png" width ="400">
<img src="https://user-images.githubusercontent.com/35964306/81240973-5b45c700-8fdf-11ea-81ce-8c73c6091f85.png" width="400" >
