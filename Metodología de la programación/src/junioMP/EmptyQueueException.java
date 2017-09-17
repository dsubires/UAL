package junioMP;

public class EmptyQueueException extends Exception
{
    /**
     * Constructor para la excepcion.
     * @param inicializa con mensaje de la expecption
     */
    public EmptyQueueException(String error)
    {
        super( error );
    }
}
