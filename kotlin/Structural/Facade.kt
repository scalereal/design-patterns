// These are some of the classes of a complex 3rd-party video
// conversion framework. We don't control that code, therefore
// can't simplify it.

class VideoFile {

}

class OggCompressionCodec {

}

class MPEG4CompressionCodec {

}

class CodecFactory {

}

class BitrateReader {

}

class AudioMixer {

}

// We create a facade class to hide the framework's complexity
// behind a simple interface. It's a trade-off between
// functionality and simplicity.

class VideoConversionFacade {
    fun convertVideo(fileName: String, format: String): File {
        println("VideoConversionFacade: conversion started.")
        val file = VideoFile(fileName)
        val sourceCodec: Codec = CodecFactory.extract(file)
        val destinationCodec: Codec
        destinationCodec = if (format == "mp4") {
            MPEG4CompressionCodec()
        } else {
            OggCompressionCodec()
        }
        val buffer: VideoFile = BitrateReader.read(file, sourceCodec)
        val intermediateResult: VideoFile = BitrateReader.convert(buffer, destinationCodec)
        val result: File = AudioMixer().fix(intermediateResult)
        println("VideoConversionFacade: conversion completed.")
        return result
    }
}

fun main(args: Array<String>) {
    val converter = VideoConversionFacade()
    val mp4Video: File = converter.convertVideo("youtubevideo.ogg", "mp4")
    // ...
}