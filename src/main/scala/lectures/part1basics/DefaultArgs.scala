package lectures.part1basics

object DefaultArgs extends App {
  def factorial(n: Int, acc: Int) : Int = {
    if (n <= 1) acc
    else factorial(n -1, n * acc)
  }
  // the above function signature can be modified to have default argument for accumulator as that will mostly be 1

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080) : Unit = println("save the damn picture")
  // now we can use this function as is
  savePicture()
  savePicture(format = "png")
  savePicture(height = 768)
  savePicture(height = 768, width = 800, format = "bmp")

  // we can use named arguments too to swap them around
  // incase the first parameter in the signature of a function has default values and not others, it becomes mandatory to pass the default value too
  // as other wise compiler chicha will complain
}
