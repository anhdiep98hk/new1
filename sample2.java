/// validation dtd using sax
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
 
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.InputSource;
 
/**
 * This is a sample of entity-resolvers usage.
 * Resolvers are used to substitute referenced network
 * resourced by local (downloaded) copies.
 */
 
public class sample2 {
    /**
     * Application entry point
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        try {
            // creates and returns new instance of SAX-implementation:
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(true);
             
            // create SAX-parser...
            SAXParser parser = factory.newSAXParser();
            // parser.getXMLReader().setEntityResolver();
             
            // .. define our handler:
            SaxHandler handler = new SaxHandler();
             
            // and parse:
            parser.parse("sample2.xml", handler);
             
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
     
    /**
     * Our own implementation of SAX handler reading
     * a purchase-order data.
     */
    private static final class SaxHandler extends DefaultHandler {

	   boolean bAddress = false;
         
        // handle references occurred in parsed XML:
        public InputSource resolveEntity(String publicId, 
                String systemId) {

			System.out.println(publicId);
			System.out.println(systemId);
             
            // this will resolve network reference to local file:
            if (systemId.equals("sample2.dtd")) {
                return new InputSource(getClass().getResourceAsStream("sample2.dtd"));
                // return null;
            } else {
                // use the default behaviour
                return null;
            }
        }
         
        // we enter to element 'qName':
        public void startElement(String uri, String localName, 
                String qName, Attributes attrs) throws SAXException {
             
            if (qName.equals("address")) {
				bAddress = true;
            }
        }

   @Override
   public void characters(char ch[], int start, int length) throws SAXException {

      if (bAddress) {
         System.out.println("Address: " + new String(ch, start, length));
         bAddress = false;
      } 
   }

        
        // this is called when document is not valid:
        public void error(SAXParseException ex) throws SAXException {
            System.out.println("ERROR: [at " + 
                    ex.getLineNumber() + "] " + ex);
        }
         
        // this is called when document is not well-formed:
        public void fatalError(SAXParseException ex) throws SAXException {
            System.out.println("FATAL_ERROR: [at " + 
                    ex.getLineNumber() + "] " + ex);
        }
         
        public void warning(SAXParseException ex) throws SAXException {
            System.out.println("WARNING: [at " + 
                    ex.getLineNumber() + "] " + ex);
        }
    }
}
