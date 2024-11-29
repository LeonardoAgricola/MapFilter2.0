## MAP FILTER 2.0.1

## Overview

`MapFilter 2.0.1` é um software gratuito para analisar e remover dados inconsistentes em conjuntos de dados agrícolas de alta densidade (dados de monitoramento de culturas, sensores de plantas, sensores de solo). Trata-se de um software simples, com uma interface amigável, cujo objetivo é ajudar os usuários a gerar mapas relacionados às suas áreas de cultivo com maior confiabilidade, por meio da otimização da qualidade dos dados. O software realiza a filtragem espacial desses dados por meio de análises globais e locais (isotrópicas e anisotrópicas), levando em consideração os valores do entorno. A visualização dos dados após a filtragem permite ao usuário realizar uma análise rápida da qualidade da filtragem espacial.


## Pré-requisitos

- **Java Runtime Environment (JRE)** versão 8 ou superior.
- Sistema Operacional: Windows, Linux, ou macOS.

## Instalação do Java

### Windows
1. Faça o download do Java Runtime Environment (JRE) do [site oficial da Oracle](https://www.oracle.com/java/technologies/javase-jre8-downloads.html) ou do [OpenJDK](https://openjdk.java.net/).
2. Siga as instruções do instalador para completar a instalação.

### Linux
1. Abra um terminal.
2. Atualize a lista de pacotes:
   ```bash
   sudo apt update
   ```
3. Instale o JRE:
    ```bash
    sudo apt install default-jre
    ```

## Download do MapFilter

1. **Faça o download do arquivo `.jar` do MapFilter**:
   - Acesse o seguinte link para baixar o arquivo: [MapFilter.jar](https://github.com/LeonardoAgricola/MapFilter2.0/blob/master/project/MapFilter.jar).

2. **Verifique o arquivo baixado**:
   - Após o download, certifique-se de que o arquivo foi baixado corretamente e está completo. O arquivo deve estar no formato `.jar`.

## Executando o MapFilter

### Windows

1. **Abra o Prompt de Comando**:
   - Você pode abrir o Prompt de Comando pesquisando por "cmd" no menu iniciar do Windows.

2. **Navegue até o diretório onde o arquivo `.jar` foi baixado**:
   ```cmd
   cd C:\Caminho\Para\O\Arquivo
   ```
3. **Execute o arquivo `.jar`**:
   - No Prompt de Comando, execute o seguinte comando para iniciar o MapFilter:
     ```cmd
     java -jar MapFilter.jar
     ```

### Linux

1. **Abra um terminal**:
   - Você pode abrir um terminal a partir do menu de aplicativos ou usando um atalho de teclado.

2. **Navegue até o diretório onde o arquivo `.jar` foi baixado**:
   ```bash
   cd /caminho/para/o/arquivo
   ```

3. **Execute o arquivo `.jar`**:
   - No terminal, execute o seguinte comando para iniciar o MapFilter:
     ```bash
     java -jar MapFilter.jar
     ```

## Problemas Comuns

- **Erro "java: command not found"**: Certifique-se de que o Java está instalado e que o caminho para o executável do Java está adicionado às variáveis de ambiente do sistema.
- **Erro de versão**: Verifique se a versão do Java instalada é compatível com a versão requerida pelo MapFilter (Java 8 ou superior).

## Contribuição

Se você deseja contribuir com este projeto, por favor, faça um fork do repositório, crie uma branch para suas alterações e envie um pull request.


## Versão 2.0

Para instalar a versão 2.0 do `MapFilter`, faça o download a partir do [link](https://github.com/LeonardoAgricola/MapFilter2.0/releases/download/2.0/MapFilter.2.1.exe) e execute o arquivo:
```
MapFilter.2.1.exe
```

### Tutorial

[Versão em Inglês](Tutorial/Tutorial_en.md)        
[Versão em Português](Tutorial/Tutorial_pt.md)

Um [vídeo](https://www.youtube.com/watch?v=7eFH_dt4OMw&t=23s) também está disponível no canal do YouTube do [Laboratório de Agricultura de Precisão (ESALQ/USP)](https://www.youtube.com/channel/UCl6Lstj-l_1P8FHrpXKyAqA).

## Citação

Maldaner, L. F., Molin, J. P., & Spekken, M. (2021). Methodology to filter out outliers in high spatial density data to improve maps reliability. *Scientia Agricola*, 79. [https://doi.org/10.1590/1678-992X-2020-0178](https://www.scielo.br/j/sa/a/7HzMhcvDpFMJx6pTGrSQLBw/?lang=en)

## Informações de Contato

[Dr. Leonardo Felipe Maldaner](mailto:maldanerlf@hotmail.com)    
Engenheiro Agrícola - UFGD    
Doutor em Ciências - Engenharia de Sistemas Agrícolas ESALQ USP    

[Dr. José Paulo Molin](mailto:jpmolin@usp.br)  
Professor Associado III na Universidade de São Paulo  
Coordenador do Laboratório de Agricultura de Precisão - LAP        

Av. Pádua Dias, 11 – 13418-900 – Piracicaba - SP    
Departamento de Engenharia de Biossistemas, USP/ESALQ