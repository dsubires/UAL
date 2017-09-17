using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;
using System.Linq;

namespace dsp086.Practica_08
{
    [TestClass]
    public class ConsultasTest
    {
        [TestMethod]
        public void ConsultasCargarDatosOK()
        {
            Consultas consultas = new Consultas();
            Assert.IsNotNull(consultas);
        }

        [TestMethod]
        public void SalidasConsultasnoEstanVacias()
        {
            // salidas consultas
            IEnumerable<vmNombre> enumerable;
            IEnumerable<vmCategoriaNombre> enumerable2;
            IEnumerable<IGrouping<string, vmCategoriaNombre>> enumerable3;
            IEnumerable<vmNombreCantidad> enumerable4;

            //consulta 1
            Consultas consulta = new Consultas();
            enumerable = consulta.UsuariosEnCategoria(1);
            Assert.IsNotNull(enumerable);
            //consulta 2
            enumerable = consulta.UsuariosEnCategoria("Alumno");
            Assert.IsNotNull(enumerable);
            //consulta 3
            enumerable = consulta.UsuariosConNombreComienza("Di");
            Assert.IsNotNull(enumerable);
            //consulta 4
            enumerable = consulta.UsuariosConNombreComienzaEnCategoria("Jo", "Profesor");
            Assert.IsNotNull(enumerable);
            //consulta 5
            enumerable = consulta.UsuariosConectadosIP("192.168.134.108");
            Assert.IsNotNull(enumerable);
            //consulta 6
            enumerable = consulta.EncontrarUsuarioAppEmail("Excel", "Juan.pss-2@ual.es");
            Assert.IsNotNull(enumerable);
            //consulta 7
            enumerable2 = consulta.ListaParCategoriaUsuarioParaApp("Word");
            Assert.IsNotNull(enumerable2);
            //consulta 8
            enumerable3 = consulta.AgrupacionUsuariosCategorias();
            Assert.IsNotNull(enumerable3);
            //consulta 9
            enumerable2 = consulta.AgrupacionUsuariosCategoriasOrdenadas();
            Assert.IsNotNull(enumerable2);
            //consulta 10
            enumerable2 = consulta.CategoriaMaximoNumeroUsuarios();
            Assert.IsNotNull(enumerable2);
            //consulta 11
            enumerable2 = consulta.TodasCategoriasApp("Word");
            Assert.IsNotNull(enumerable2);
            //consulta 12
            enumerable2 = consulta.CategoriasAplicacionParaUsuario("Juan");
            Assert.IsNotNull(enumerable2);
            //consulta 13
            enumerable4 = consulta.IPconMasConexionesSegunCategoria("Administrador");
            Assert.IsNotNull(enumerable4);
            //consulta 14
            enumerable4 = consulta.UsuarioSumaDuracionConexiones();
            Assert.IsNotNull(enumerable4);
            //consulta 15
            enumerable4 = consulta.UsuarioSumaDuracionConexionesNulos();
            Assert.IsNotNull(enumerable4);
            //consulta 16
            enumerable4 = consulta.UsuariosSumaDuracionMayorMedia();
            Assert.IsNotNull(enumerable4);
            //consulta 17
            enumerable4 = consulta.AplicacionesMasUsadas();
            Assert.IsNotNull(enumerable4);
            //consulta 18
            enumerable4 = consulta.AplicacionesMasUsadasOrdenadas();
          

        }


    }
}
