import BitrateReader.convert
import BitrateReader.read
import CodecFactory.extract
import java.io.File;

class VideoFile(private val name: String) {
    val codecType: String = name.substring(name.indexOf(".") + 1)
}

interface Codec {
}

class MPEG4CompressionCodec : Codec {
    var type = "mp4"
}

class OggCompressionCodec : Codec {
    var type = "ogg"
}

object CodecFactory {
    fun extract(file: VideoFile): Codec {
        val type = file.codecType
        return if (type == "mp4") {
            println("CodecFactory: extracting mpeg audio...")
            MPEG4CompressionCodec()
        } else {
            println("CodecFactory: extracting ogg audio...")
            OggCompressionCodec()
        }
    }
}

object BitrateReader {
    fun read(file: VideoFile, codec: Codec?): VideoFile {
        println("BitrateReader: reading file...")
        return file
    }

    fun convert(buffer: VideoFile, codec: Codec?): VideoFile {
        println("BitrateReader: writing file...")
        return buffer
    }
}

class AudioMixer {
    fun fix(result: VideoFile?): File {
        println("AudioMixer: fixing audio...")
        return File("tmp")
    }
}

class VideoConversionFacade {
    fun convertVideo(fileName: String?, format: String): File {
        println("VideoConversionFacade: conversion started.")
        val file = VideoFile(fileName!!)
        val sourceCodec = extract(file)
        val destinationCodec: Codec = if (format == "mp4") {
            MPEG4CompressionCodec()
        } else {
            OggCompressionCodec()
        }
        val buffer = read(file, sourceCodec)
        val intermediateResult = convert(buffer, destinationCodec)
        val result = AudioMixer().fix(intermediateResult)
        println("VideoConversionFacade: conversion completed.")
        return result
    }
}

fun main(args: Array<String>) {
    val converter = VideoConversionFacade()
    val mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4")
    // ...
}
