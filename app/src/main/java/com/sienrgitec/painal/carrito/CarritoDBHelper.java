package com.sienrgitec.painal.carrito;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sienrgitec.painal.pojo.carrito.Carrito;
import com.sienrgitec.painal.pojo.entity.TtCtArtProveedor_;

import java.util.ArrayList;
import java.util.List;

public class CarritoDBHelper extends SQLiteOpenHelper {

    private static final int VERSION_BASEDATOS = 2;

    // Nombre de nuestro archivo de base de datos
    private static final String NOMBRE_BASEDATOS = "carrito.db";

    // Sentencia SQL para la creación de una tabla
    private static final String TABLA_PEDIDO = "CREATE TABLE pedido" +
            "(_id INTEGER PRIMARY KEY AUTOINCREMENT, _idArt INTEGER, cantidadArticulo DECIMAL(10,2), monto DECIMAL(10,2))";

    private static final String TABLA_ARTICULO = "CREATE TABLE articulo (\n" +
            "    _idArt INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "iProveedor INT, " +
            "iArticulo INT, " +
            "cArticulo TEXT, " +
            "cAplicaciones TEXT, " +
            "cPresentacion TEXT, " +
            "cDescripcion TEXT, " +
            "iImpuesto INT, " +
            "iCategoria INT, " +
            "iSubCategoria INT, " +
            "iClasificacion INT, " +
            "iSubClasificacion INT,  " +
            "iMarca INT, " +
            "lActivo INT, " +
            "lAgotado INT, " +
            "dePeso DECIMAL(10,2) , " +
            "deLargo DECIMAL(10,2) , " +
            "deAncho DECIMAL(10,2) , " +
            "deProfundo DECIMAL(10,2) , " +
            "cUsuCrea TEXT, " +
            "cUsuModifica TEXT, " +
            "dePrecioVtaPza DECIMAL(10,2) , " +
            "deImpuestoPza DECIMAL(10,2) , " +
            "dePrecioVtaGranel DECIMAL(10,2) , " +
            "deImpuestoGranel DECIMAL(10,2) , " +
            "iUMedida INT, " +
            "cUnidadM TEXT, " +
            "cMarca TEXT, " +
            "cCategoria TEXT, " +
            "cSubCategoria TEXT, " +
            "cClasificacion TEXT, " +
            "cSubClasificacion TEXT " +
            ")";

    // CONSTRUCTOR de la clase
    public CarritoDBHelper(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_ARTICULO);
        db.execSQL(TABLA_PEDIDO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS articulo");
        db.execSQL("DROP TABLE IF EXISTS pedido");
        onCreate(db);
    }

    public long insertarArticulo(TtCtArtProveedor_ articulo) {
        SQLiteDatabase db = getWritableDatabase();
        long idArt = 0L;
        if(db != null){
            ContentValues valores = new ContentValues();
            valores.put("iProveedor",articulo.getIProveedor());
            valores.put("iArticulo",articulo.getIArticulo());
            valores.put("cArticulo",articulo.getCArticulo());
            valores.put("cAplicaciones",articulo.getCAplicaciones());
            valores.put("cPresentacion",articulo.getCPresentacion());
            valores.put("cDescripcion",articulo.getCDescripcion());
            valores.put("iImpuesto",articulo.getIImpuesto());
            valores.put("iCategoria",articulo.getICategoria());
            valores.put("iSubCategoria",articulo.getISubCategoria());
            valores.put("iClasificacion",articulo.getIClasificacion());
            valores.put("iSubClasificacion",articulo.getISubClasificacion());
            valores.put("iMarca",articulo.getIMarca());
            valores.put("lActivo",articulo.getLActivo());
            valores.put("lAgotado",articulo.getLAgotado());
            valores.put("dePeso",articulo.getDePeso());
            valores.put("deLargo",articulo.getDeLargo());
            valores.put("deAncho",articulo.getDeAncho());
            valores.put("deProfundo",articulo.getDeProfundo());
            valores.put("cUsuCrea",articulo.getCUsuCrea());
            valores.put("cUsuModifica",articulo.getCUsuModifica());
            valores.put("dePrecioVtaPza",articulo.getDePrecioVtaPza());
            valores.put("deImpuestoPza",articulo.getDeImpuestoPza());
            valores.put("dePrecioVtaGranel",articulo.getDePrecioVtaGranel());
            valores.put("deImpuestoGranel",articulo.getDeImpuestoGranel());
            valores.put("iUMedida",articulo.getIUMedida());
            valores.put("cUnidadM",articulo.getCUnidadM());
            valores.put("cMarca",articulo.getCMarca());
            valores.put("cCategoria",articulo.getCCategoria());
            valores.put("cSubCategoria",articulo.getCSubCategoria());
            valores.put("cClasificacion",articulo.getCClasificacion());
            valores.put("cSubClasificacion",articulo.getCSubClasificacion());
            idArt = db.insert("articulo", null, valores);
            db.close();
        }
        return idArt;
    }

    public void insertarPedido(Carrito carrito){

        // Se Inserta el articulo
        long idArt = insertarArticulo(carrito.getArticulo());

        SQLiteDatabase db = getWritableDatabase();
        if(db != null) {
            ContentValues valores = new ContentValues();
            valores.put("_idArt", idArt);
            valores.put("cantidadArticulo", carrito.getCantidadArticulo());
            valores.put("monto", carrito.getMonto());
            db.insert("pedido", null, valores);
            db.close();
        }
    }

    public void vaciaCarrito(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from pedido");
        db.execSQL("delete from articulo");
    }

    public List<Carrito> recuperarPedidos() {
        SQLiteDatabase db = getReadableDatabase();
        List<Carrito> lista_pedido = new ArrayList<Carrito>();
        String[] valores_recuperar = {"_id", "_idArt", "cantidadArticulo", "monto"};
        Cursor c = db.query("pedido", valores_recuperar,
                null, null, null, null, null, null);
        if(c.getCount() > 0) {
            c.moveToFirst();
            do {
                Carrito carrito = new Carrito(recuperarArticulo(c.getInt(1)),
                        c.getDouble(2), c.getDouble(3));
                lista_pedido.add(carrito);
            } while (c.moveToNext());
        }
        db.close();
        c.close();
        return lista_pedido;
    }

    public TtCtArtProveedor_ recuperarArticulo(int id) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"_idArt", "iProveedor",
                "iArticulo",
                "cArticulo",
                "cAplicaciones",
                "cPresentacion",
                "cDescripcion",
                "iImpuesto",
                "iCategoria",
                "iSubCategoria",
                "iClasificacion",
                "iSubClasificacion",
                "iMarca",
                "lActivo",
                "lAgotado",
                "dePeso",
                "deLargo",
                "deAncho",
                "deProfundo",
                "cUsuCrea",
                "cUsuModifica",
                "dePrecioVtaPza",
                "deImpuestoPza",
                "dePrecioVtaGranel",
                "deImpuestoGranel",
                "iUMedida",
                "cUnidadM",
                "cMarca",
                "cCategoria",
                "cSubCategoria",
                "cClasificacion",
                "cSubClasificacion"};

        Cursor c = db.query("articulo", valores_recuperar, "_idArt=" + id,
                null, null, null, null, null);
        TtCtArtProveedor_ articulo = new TtCtArtProveedor_();
        if(c != null && c.getCount() > 0) {
            c.moveToFirst();
            articulo.setIProveedor(c.getInt(1));
            articulo.setIArticulo(c.getInt(2));
            articulo.setCArticulo(c.getString(3));
            articulo.setCAplicaciones(c.getString(4));
            articulo.setCPresentacion(c.getString(5));
            articulo.setCDescripcion(c.getString(6));
            articulo.setIImpuesto(c.getInt(7));
            articulo.setICategoria(c.getInt(8));
            articulo.setISubCategoria(c.getInt(9));
            articulo.setIClasificacion(c.getInt(10));
            articulo.setISubClasificacion(c.getInt(11));
            articulo.setIMarca(c.getInt(12));
            articulo.setLActivo(c.getInt(13) == 1 ? true : false);
            articulo.setLAgotado(c.getInt(14) == 1 ? true : false);
            articulo.setDePeso(c.getDouble(15));
            articulo.setDeLargo(c.getDouble(16));
            articulo.setDeAncho(c.getDouble(17));
            articulo.setDeProfundo(c.getDouble(18));
            articulo.setCUsuCrea(c.getString(19));
            articulo.setCUsuModifica(c.getString(20));
            articulo.setDePrecioVtaPza(c.getDouble(21));
            articulo.setDeImpuestoPza(c.getDouble(22));
            articulo.setDePrecioVtaGranel(c.getDouble(23));
            articulo.setDeImpuestoGranel(c.getDouble(24));
            articulo.setIUMedida(c.getInt(25));
            articulo.setCUnidadM(c.getString(26));
            articulo.setCMarca(c.getString(27));
            articulo.setCCategoria(c.getString(28));
            articulo.setCSubCategoria(c.getString(29));
            articulo.setCClasificacion(c.getString(30));
            articulo.setCSubClasificacion(c.getString(31));
        }
        db.close();
        c.close();
        return articulo;
    }

}
