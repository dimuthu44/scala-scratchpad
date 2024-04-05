package apache.fop

import org.apache.fop.apps._

import javax.xml.transform._
import javax.xml.transform.sax.SAXResult
import javax.xml.transform.stream.StreamSource
import java.io._
import org.apache.xmlgraphics.util.MimeConstants
import freemarker._
import freemarker.cache.FileTemplateLoader
import freemarker.ext.beans.{BeansWrapper, SimpleMapModel}
import freemarker.template._

object PDFGenerator {
  def main(args: Array[String]): Unit = {

    val customerName = "Dombås Hotel"

    try {
      val fopFactory = FopFactory.newInstance(new File(".").toURI)

      val outputStream = new BufferedOutputStream(new FileOutputStream("src/main/resources/sample.pdf"))

      val factory = TransformerFactory.newInstance
      val transformer = factory.newTransformer

      val xslFilePath = "src/main/scala/apache/fop/template.xsl"
      // Load the XSL-FO template from file
      val templateFile = new File(xslFilePath)
      val template = new FileReader(templateFile)

      // Prepare FreeMarker data model with parameters
      val paramMap = new java.util.HashMap[String, String]()
      paramMap.put("customerName", customerName)
      val config = new Configuration(Configuration.getVersion)
      config.setObjectWrapper(new BeansWrapper(Configuration.getVersion))
      val dataModel = new SimpleMapModel(paramMap, config.getObjectWrapper.asInstanceOf[BeansWrapper])

      // Process the template with FreeMarker to replace placeholders
      val freemarkerTemplate = new Template(xslFilePath, template, config)
      val writer = new StringWriter()
      freemarkerTemplate.process(dataModel, writer)

      println(writer.toString)

      val source = new StreamSource(new StringReader(writer.toString))

      val fop = fopFactory.newFop(MimeConstants.MIME_PDF, outputStream)

      val result = new SAXResult(fop.getDefaultHandler)
      transformer.transform(source, result)

      outputStream.close()
      println("PDF created successfully.")
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}
