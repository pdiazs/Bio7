import ij.IJ;

/*
This example demonstrates how to process image stacks or *.avi files
with ImageJ and R. Please load a stack or *.avi file (which ImageJ can open!).
After the compilation(Press the start button and adjust the speed)
all frames of the stack are processed and analysed with R.
*/

int slice=1;
double timeOut;
long time;

public void ecomain(){
time = System.currentTimeMillis();

IJ.run("Set Slice...", "slice=" + slice);
/*Transfer as integer! ->0=double, 1=integer, 2=byte*/
ImageMethods.imageToR("current",false,1);
RServe.print("mean(as.integer(current))");
//RServe.print("mean(fft(as.integer(current)))");

timeOut = (double)(System.currentTimeMillis() - time)/1000;
System.out.println("Time: (seconds) " + timeOut +" Fps: "+1/timeOut);

slice++;
}