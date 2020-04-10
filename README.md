# simply-weather-cli

![](https://www.seekpng.com/png/full/54-541679_lightning-thunderstorm-png-png-images-storm-clouds-transparent.png)

## Installation

```sh
# Clone the repository with Git
$ git clone https://github.com/kwachu2/simply-weather-cli.git
   
# Go into the repository
$ cd simply-weather-cli
   
# Build JAR file with Maven 
$ mvn package 

# Go into the directory with built app
$ cd target
   
# Run the app with Java Virtual Machine
$ java -jar simply-weather-cli-0.0.1.jar -h
```

### Options

| Option | Arguments | Description |
| ------ | ------ | ------ |
| -h, --help | no arguments | Display help menu 
| -C, --current | no arguments | Set if you want to know the current weather 
| -F, --forecast  | no arguments | Set to print available forecast dates and times
| -F, --forecast  | < "yyyy-MM-dd HH:mm:ss" > | Set this to view the forecast
| -c, --city | < city name > | Enter the name of the city you are looking for
| -g, --geo | < latitude longitude > | Set to search by geographic coordinates

### Examples  
- ```java -jar simply-weather-cli-0.0.1.jar -C -c Warsaw```  
will display the current weather for Warsaw.  
- ```java -jar simply-weather-cli-0.0.1.jar -C -g 52.23 21.01```  
will display the current weather for Warsaw, but the search will be based on geographical coordinates.  
- ```java -jar simply-weather-cli-0.0.1.jar -F -c Warsaw```  
will print out available dates and times of forecasts for Warsaw.  
- ```java -jar simply-weather-cli-0.0.1.jar -F "2020-04-12 23:00:00" -c Warsaw```  
will display the forecast for the given available date and time for Warsaw.  

## The app was build with

* [Maven](https://maven.apache.org/) - Dependency Management.
* [Commons CLI](http://commons.apache.org/proper/commons-cli/) - Provides a simple API for presenting, processing and validating a command line interface.
* [Unirest Java](http://unirest.io/) - Simplified, lightweight HTTP client library
* [Project Lombok](https://projectlombok.org/) - Automatic Resource Management, automatic generation of getters, setters, equals, hashCode and toString, and more.
* [SLF4J](http://www.slf4j.org/) - Logging and printing to console.
* [OpenWeatherMap API](https://openweathermap.org/api) - APIs for providing current and forecast weather data.
