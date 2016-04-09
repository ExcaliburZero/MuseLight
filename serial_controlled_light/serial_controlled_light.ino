const int red = 11;
const int green = 10;
const int blue = 9;

void setup() {
  Serial.begin(9600);
  pinMode(red, OUTPUT);
  pinMode(green, OUTPUT);
  pinMode(blue, OUTPUT);

}

void loop() {
  if(Serial.available()) {
    int value = Serial.read();
    if(value == 0)
      digitalWrite(red, LOW);
    else if(value == 1)
      digitalWrite(red, HIGH);
    else if(value == 2)
      digitalWrite(green, LOW);
    else if(value == 3)
      digitalWrite(green, HIGH);
    else if(value == 4)
      digitalWrite(blue, LOW);
    else if(value == 5)
      digitalWrite(blue, HIGH);
    
  }

}
