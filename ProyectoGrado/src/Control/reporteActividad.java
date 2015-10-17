package Control;

//Metodo encargado de generar reporte de las actividades.
import static Control.reporteEntrega.agregarLineasEnBlanco;
import static Control.reporteEntrega.agregarMetaDatos;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;

/**
 *
 * @author Tavo
 */
public class reporteActividad {

    private String strNombreDelPDF;
    public Font fuenteNegra10 = new Font();
    private Font fuente8 = new Font();
    private Font fuenteAzul25 = new Font();
    BaseColor grisClaro = new BaseColor(230, 230, 230);
    BaseColor azulClaro = new BaseColor(124, 195, 255);
    Font Tamano = new Font(Font.FontFamily.TIMES_ROMAN, 10);
    //############# VARIABLES PARA MANEJO DE BASE DE DATOS ########################
    //Guarda la consulta operacion a realizar
    String strConsultaSQL;
    //Apuntador a la conexion
    //Para ejecutar operaciones SQL
    //Para guardar los resultados de una operacion SELECT
    ResultSet rs;
    Document document;
    PdfWriter writer;
    String strRotuloPDF;

    //Metodo principal del ejemplo
    public reporteActividad(String titulo, String nomPDF) {
        strRotuloPDF = titulo;
        strNombreDelPDF = nomPDF;
        try {       //Hoja tamanio carta, rotarla (cambiar a horizontal)
            document = new Document(new Rectangle(800f, 1200f));

            writer = PdfWriter.getInstance(document, new FileOutputStream("src/Reportes/" + strNombreDelPDF));
            document.open();

            agregarMetaDatos(document);
            agregarContenido(document);

            document.close();

            System.out.println("Se ha generado el PDF: " + strNombreDelPDF);

        } catch (FileNotFoundException | DocumentException e) {
            e.getMessage();
        }
    }

    //agrega el contenido del documento; para este ejemplo agrega una tabla con datos y una imagen
    //Espera como entrada el documento donde agregara el contenido
    public void agregarContenido(Document document) throws DocumentException {
        Paragraph ParrafoHoja = new Paragraph();

        // Agregamos una linea en blanco al principio del documento
        agregarLineasEnBlanco(ParrafoHoja, 1);
        // Colocar un encabezado (en mayusculas)
        ParrafoHoja.add(new Paragraph(strRotuloPDF.toUpperCase(), fuenteAzul25));
        agregarLineasEnBlanco(ParrafoHoja, 1);
        // 1.- AGREGAMOS LA TABLA
        agregarTabla(ParrafoHoja);
        //Agregar 2 lineas en blanco
        agregarLineasEnBlanco(ParrafoHoja, 2);
        // 2.- AGREGAMOS LA IMAGEN
        try {
            Image im = Image.getInstance("src/Imagen/entrar.png");
            System.out.println("img ... " + im.toString());
            im.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP);
            im.setWidthPercentage(50);
            ParrafoHoja.add(im);
        } catch (BadElementException | IOException e) {
            e.getMessage();
            System.out.println("error cargando img ... " + e);
        }

        document.add(ParrafoHoja);

    }

    //Se conecta al DBMS MySQL , obtiene los datos de la tabla (SELECT) y los acomoda en una tabla JTable de iText.
    // Espera como entrada el parrafo donde agregara la tabla
    public void agregarTabla(Paragraph parrafo) throws BadElementException {
        //Anchos de las columnas
        float anchosFilas[] = {1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f};
        PdfPTable tabla = new PdfPTable(anchosFilas);
        String rotulosColumnas[] = {"CODIGO", "TITULO", "PROYECTO", "ENTREGA", "INICIO", "FIN",
            "FIN REAL", "ESTADO", "RESPONSABLE"};
        // Porcentaje que ocupa a lo ancho de la pagina del PDF
        tabla.setWidthPercentage(104);
        //Alineacion horizontal centrada
        tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
        //agregar celda que ocupa las 9 columnas de los rotulos
        PdfPCell cell = new PdfPCell(new Paragraph("ACTIVIDADES"));
        cell.setColspan(13);
        //Centrar contenido de celda
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        //Color de fondo de la celda
        cell.setBackgroundColor(azulClaro);
        tabla.addCell(cell);

        try {
            if (!ejecucionBD.getConn().isClosed()) {
                // Mostrar los rotulos de las columnas
                for (int i = 0; i < rotulosColumnas.length; i++) {
                    cell = new PdfPCell(new Paragraph(rotulosColumnas[i], fuenteNegra10));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(grisClaro);
                    tabla.addCell(cell);
                }

                //Consultar la tabla proyectos
                strConsultaSQL = "select codigo_actividad as \"CODIGO\",actividad.titulo, proyecto.titulo as \"PROYECTO\", entrega.titulo as \"ENTREGA\", \n"
                        + "to_char(actividad.FECHA_INI,'dd/MM/yyyy') as \"INICIO\", to_char(actividad.fecha_fin,'dd/MM/yyyy') as \"FIN\", \n"
                        + "to_char(actividad.fecha_fin_real,'dd/MM/yyyy') as \"FIN REAL\", actividad.estado, personal.nombre as \"RESPONSABLE\"\n"
                        + "from actividad, personal, entrega, proyecto where \n"
                        + "entrega.codigo_entrega = actividad.entrega\n"
                        + "and personal.codigo_personal = actividad.responsable and entrega.proyecto = proyecto.codigo_proy order by actividad.codigo_actividad";


                rs = ejecucionBD.st.executeQuery(strConsultaSQL);

                //Iterar Mientras haya una fila siguiente
                while (rs.next()) {
                    //Agregar 9 celdas

                    cell = new PdfPCell(new Paragraph(rs.getString(1), fuente8));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla.addCell(cell);

                    cell = new PdfPCell(new Paragraph(rs.getString(2), fuente8));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla.addCell(cell);

                    cell = new PdfPCell(new Paragraph(rs.getString(3), fuente8));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla.addCell(cell);

                    cell = new PdfPCell(new Paragraph(rs.getString(4), fuente8));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla.addCell(cell);

                    cell = new PdfPCell(new Paragraph(rs.getString(5), fuente8));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla.addCell(cell);

                    cell = new PdfPCell(new Paragraph(rs.getString(6), fuente8));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla.addCell(cell);

                    cell = new PdfPCell(new Paragraph(rs.getString(7), fuente8));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla.addCell(cell);

                    cell = new PdfPCell(new Paragraph(rs.getString(8), fuente8));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla.addCell(cell);

                    cell = new PdfPCell(new Paragraph(rs.getString(9), fuente8));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla.addCell(cell);

                }

                //Cerrar los objetos de manejo de BD
                //ResultSet
            }       //Fin de if que comprueba si se pudo conectar

        } catch (Exception e) {
            System.out.println("Excepcion al ejecutar CONSULTA!!!" + e.getMessage());
            //Mostrar la traza de la pila
        }
        //Agregar la tabla con los datos al parrafo que nos llego como entrada
        parrafo.add(tabla);
    }  //Fin del metodo que crea la tabla

    //Agrega las lineas en blanco  especificadas a un parrafo especificado
    public static void agregarLineasEnBlanco(Paragraph parrafo, int nLineas) {
        for (int i = 0; i < nLineas; i++) {
            parrafo.add(new Paragraph(" "));
        }
    }

    //Agrega los metadatos del documento, los metadatos a asignar son
    //Titulo, Asunto, Palabras clave, Autor y el sw o org con el cual fue generado
    public static void agregarMetaDatos(Document document) {
        document.addTitle("Documento con datos de tabla Entregas");
        document.addSubject("Usando iText y Oracle");
        document.addKeywords("GusJava, PDF, iText");
        document.addAuthor("tavo ruiz");
    }

    //Abre el documento PDF
    public void abrirPDF() {
        /* Abrir el archivo PDF */
        try {
            Runtime.getRuntime().exec("gnome-open src/Reportes/" + strNombreDelPDF);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
