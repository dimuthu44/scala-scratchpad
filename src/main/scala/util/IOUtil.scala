package util

import java.io.{InputStream, OutputStream}

object IOUtil {
  def fastCopy(src: InputStream, dest: OutputStream): Unit = {
    val buffer = new Array[Byte](8 * 1024)
    var len = 0

    def read: Boolean = {
      len = src.read(buffer)
      len != -1
    }
    while (read) dest.write(buffer, 0, len)
  }


}
