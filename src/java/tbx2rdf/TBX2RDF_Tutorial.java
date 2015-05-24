package tbx2rdf;

import java.io.FileReader;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.jena.riot.RDFDataMgr;
import org.openjena.riot.Lang;
import org.xml.sax.SAXException;
import tbx2rdf.types.TBX_Terminology;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.vocabulary.RDF;
import java.io.FileReader;
import java.util.List;

import tbx2rdf.types.TBX_Terminology;
import tbx2rdf.vocab.ONTOLEX;
import tbx2rdf.vocab.SKOS;
import tbx2rdf.vocab.TBX;
/**
 * Some static methods for a fast introduction to TBX2RDF
 * @author vroddon
 */
public class TBX2RDF_Tutorial {
    
    public static void main(String[] args) throws Exception{
     
        Example1();
    }
    
    public static void Example1() throws Exception
    {
        final Mappings mappings = Mappings.readInMappings("mappings.default");
        final TBX_Terminology terminology = new TBX2RDF_Converter().convert(new FileReader("samples/simple_with_decomp_trans.xml"), mappings);
        Model model = terminology.getModel("file:samples/simple_with_decomposition.rdf");
        RDFDataMgr.write(System.err,model, Lang.TURTLE);
    }
}
