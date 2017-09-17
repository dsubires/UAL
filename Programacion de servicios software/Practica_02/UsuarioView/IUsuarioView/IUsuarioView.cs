using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_02
{

    public interface IUsuarioView
    {

        string Id { get; set; }
        string Nombre { get; set; }
        string PalabraPaso { get; set; }
        string Categoria { get; set; }
        bool EsValido { get; set; }


    }


}
