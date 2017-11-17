
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  int val = analogRead(0);
  int por = map(val, 0, 1023, 0, 100);
  Serial.print("Valor analogico: ");
  Serial.print(val);
  Serial.print(" Porcentaje: ");
  Serial.print(por);
  Serial.println("%");
  delay(1000);
}
