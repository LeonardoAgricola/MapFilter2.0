## MapFilter 2.0 User Tutorial

## Initial setting

The ** MapFilter 2.0 ** processes numerical data with a decimal separator `.` (point). The configuration can be done through the control panel:

Control panel> Clock and Region> Change date, time or number format> Additional settings

Then change the fields as follows:

> Decimal symbol: `.` (point)  
> Digit grouping symbol: `,` (comma)  
> List separator: `,` (comma)  


## Data file format

**MapFilter** processes a single data set in a text format file (`.txt` or` .csv`) at a time. The text file must contain at least _**three attributes numeric**_: two attributes containing the **latitude** and **longitude** and the **attribute** that will be subjected to filtering.

### Important

* The first line of the file must contain a header (name) of attributes;
* Coordinates must be in the WGS 84 datum provided in **geographic coordinates (decimal degrees)**, which is a common way for storing coordinates in agricultural data recorders or in **metric form (UTM)**;
* The coordinates must have the header named with the initials **"Lat"** and **"Long"** or **"X"** and **"Y"**.

## Data filtering

### Starting the software

To start the **MapFilter 2.0** software, just click on the Window Start Menu. Then go to the **LAP USP** folder and click **MapFilter**.<br/>

<p align="center">
     <a href="#"><img src="https://github.com/LeonardoTche/MapFilter2.0/blob/master/Tutorial/Img/telaIinicial.png" width="700"/></a>          <br>  
  <em> Software interface </em>
</p>

### Select file

In this tutorial we will use a data set of the corn yield as an example.<br/>

To open the data set to be filtered, click in  [![image](https://github.com/LeonardoTche/MapFilter2.0/blob/master/Tutorial/Img/img2.png?raw="True")](#features) and select the file [`corn_yield.txt`](/Exemplo/).<br/>

### Identify the attribute to be filtered

Identify the attribute to be filtered:

<p align="center">
     <a href="#"><img src="https://github.com/LeonardoTche/MapFilter2.0/blob/master/Tutorial/Img/img3.png" width="300"/></a> 
</p> 

The attribute data to be filtered are plotted on the display and the descriptive statistics are calculated: <br/>
<br/>

<p align="center">
     <a href="#"><img src="https://github.com/LeonardoTche/MapFilter2.0/blob/master/Tutorial/Img/img4.png" width="700"/></a>
     <br>
     <em> Raw data preview </em>
</p>
<br/>

The global filter was added before the local filter to avoid inflation of variations of the attribute values in the local analysis due to very low or very high values. In the global filter, the median of the values of the attribute under analysis is used to calculate the upper (Eq. 1) and lower (Eq. 2) cutoff limits:
```
Upper limit = median + median x v                                                                  Equation 1
Lower limit = median - median x v                                                                  Equation 2
```

The value of `v` must be entered by the user in the field` Variation of limit (%) `

<br/>

<p align="center">
     <a href="#"><img src="https://github.com/LeonardoTche/MapFilter2.0/blob/master/Tutorial/Img/filt_globalVar.png" width="300"/></a> 
</p>

<br/>


In our example we will use `v = 35`

To perform global filtering click on the icon [![image](https://github.com/LeonardoTche/MapFilter2.0/blob/master/Tutorial/Img/img7.png?raw=true)](#features)  

<br>

After global filtering, **MapFilter** plots and recalculates the descriptive statistics of the remaining filtering data. In this example, global filtering eliminated all data with productivity values above 7.53 and below 3.63. <br/>
<br/>

<p align="center">
     <a href="#"><img src="https://github.com/LeonardoTche/MapFilter2.0/blob/master/Tutorial/Img/filt_global.png" width="700"/></a>
     <br>
     <em> Data visualization after global filtering </em>
</p>

### Local filtering

The **local filter** was divided into two stages: anisotropic and isotropic local filters. <br/>
The _**anisotropic filter**_ detects all points located in a range of _**radius (R)**_ around a point xi in a _**single direction**_. Point xi is compared with k neighbors ahead and k neighbors before. K is the number of neighbors whose Euclidean distance is less than or equal to R (blue line in Figure). The median of these k neighbors is calculated and Eq. 1 and Eq. 2 are applied to point xi. If the value of point xi is greater or less than the upper and lower cutoff limits, it will be considered a local error and will be excluded from the data set. <br/>
The _**isotropic filter**_ detects all k neighboring points located in a _**R**_ around a point xi in _**any direction**_. Then, the median of these k neighbors is calculated and Eq. 1 and Eq. 2 is applied to point xi. The filter excludes point xi with a value greater or less than the upper and lower cut limits. <br/>

<br/>
<p align="center">
     <a href="#"><img src="https://github.com/LeonardoTche/MapFilter2.0/blob/master/Tutorial/Img/esquema_en.png" width="700"/></a>
     <br>
     <em> Identification of neighboring points in local filtering </em>
</p>

<br/>

The value of the radius `R` must be informed by the user in the field` Spatial Dependence (m) `and the value of` v` must be informed by the user in the field `Variation of limit (%)` <br/>
<br/>

<p align="center">
     <a href="#"><img src="https://github.com/LeonardoTche/MapFilter2.0/blob/master/Tutorial/Img/filt_localVar.png" /></a>
     <br>
</p>
<br/>

In our example we will use `R = 100` and` v = 5`


To perform local filtering click on the icon [![image](https://github.com/LeonardoTche/MapFilter2.0/blob/master/Tutorial/Img/img7.png?raw=true)](#features)  

<br>

After local filtering **MapFilter** plots and recalculates the descriptive statistics of the remaining filtering data. <br/>
<br/>

<p align="center">
     <a href="#"><img src="https://github.com/LeonardoTche/MapFilter2.0/blob/master/Tutorial/Img/filt_local.png" width="700"/></a>
     <br>
     <em> Data visualization after local filtering </em>
</p>
<br/>

### Save the data

Data that has not been deleted by the filter can be saved in a text file (`.txt` or` .csv`). <br/>

To save the data click on the icon [![image](https://github.com/LeonardoTche/MapFilter2.0/blob/master/Tutorial/Img/salvar.png?raw=true)](#features) 

