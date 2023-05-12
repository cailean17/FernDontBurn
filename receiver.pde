//From Arduino to Processing to Txt or cvs etc.
//import
import processing.serial.*;
//declare
PrintWriter output;
Serial udSerial;

void setup() {
  udSerial = new Serial(this, "COM5", 115200);
  output = createWriter ("ArduinoData.txt");
}

  void draw() {
    if (udSerial.available() > 0) {
      String SenVal = udSerial.readString();
      if (SenVal != null) {
        System.out.println("WRITING TO FILE" + SenVal);
        output.print(SenVal);
        output.flush();
      } 
    }
  }

  void keyPressed(){
   
    output.close();
    exit(); 
  }
