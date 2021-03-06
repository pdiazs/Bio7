/*
This example calls a RScript which produces a list or matrix and transfers
it to ImageJ as an image. Please start the R server!!
 */
public void ecomain() {

	if (RServe.isAlive()) {
		if (RState.isBusy() == false) {
			/*Get the relative path to the script and convert it for R (Windows)*/
			RServe.callRScriptSilent("/Bio7_Examples/Since_1.3/randomScript.R");
			/*Create the image in ImageJ! 1=Byte transfer 3=Greyscale image!*/
			ImageMethods.imageFromR(1, "imageMatrix", 2);
		}
		else{
			System.out.println("RServer is busy!");
		}
	}
	else{
		System.out.println("RServer is not alive!");
	}
}