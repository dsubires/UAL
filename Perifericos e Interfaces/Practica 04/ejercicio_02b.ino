
const int RED = 11;
const int GREEN = 9;
const int BLUE =10;
// Valores para el nivel RGB
int rval = 0;
int gval = 0;
int bval = 0;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(RED, OUTPUT);
  pinMode(GREEN, OUTPUT);
  pinMode(BLUE, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  while (Serial.available() > 0){
    rval = Serial.parseInt();
    gval = Serial.parseInt();
    bval = Serial.parseInt();
    if (Serial.read() == '\n'){
        analogWrite(RED, rval);
        analogWrite(GREEN, gval);
        analogWrite(BLUE, bval);
    }
  }
}
