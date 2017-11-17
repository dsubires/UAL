int sensorPin = 0;

void setup() {
  // put your setup code here, to run once:
  pinMode(10, OUTPUT);
  pinMode(11, OUTPUT);
  pinMode(13, OUTPUT);
  
  Serial.begin(9600);
}

void loop() {

 //getting the voltage reading from the temperature sensor
 int reading = analogRead(sensorPin);  
 
 // converting that reading to voltage, for 3.3v arduino use 3.3
 float voltage = reading * 5.0;
 voltage /= 1024.0; 
 
 // print out the voltage
 Serial.print(voltage); Serial.println(" volts");
 
 // now print out the temperature
 float temperatureC = (voltage - 0.5) * 100 ;  //converting from 10 mv per degree wit 500 mV offset
                                               //to degrees ((voltage - 500mV) times 100)
 Serial.print(temperatureC); Serial.println(" degrees C");
 
 // now convert to Fahrenheit
 float temperatureF = (temperatureC * 9.0 / 5.0) + 32.0;
 Serial.print(temperatureF); Serial.println(" degrees F");
 

  //Dependiendo de la temperatura encendemos un led u otro
  if(temperatureC < 5){
    digitalWrite(10,HIGH);
    digitalWrite(11, LOW);
    digitalWrite(13, LOW);
  }else if(temperatureC > 25){
    digitalWrite(10, LOW);
    digitalWrite(11, HIGH);
    digitalWrite(13, LOW);
  }else{
    digitalWrite(10, LOW);
    digitalWrite(11, LOW);
    digitalWrite(13, HIGH);
  }
  
  //waiting a second
  delay(1000);                                     
}
