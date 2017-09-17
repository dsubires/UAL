using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ImplementacionXML;
using Principal;
using Exceptions;

namespace Practica_09
{
    [TestClass]
    public class UnitTest1
    {
        public AutentificacionXml autentificacion;
        // UsuarioView 1=new UsuarioView()

        [TestMethod]
        public void ComprobarFicheroCargarDatosOKTest()
        {
            try
            {
                AutentificacionXml xml = new AutentificacionXml("Usuarios.xml");
                Assert.IsFalse(false);
            }
            catch (AutentificacionExcepcion)
            {
                Assert.IsFalse(true);
            }
        }
        [TestMethod]
        public void ObtenerUsuarioTest()
        {
            AutentificacionXml xml = new AutentificacionXml("Usuarios.xml");
            IUsuarioView usu = xml.ObtenerUsuario("1");
            Assert.AreNotEqual(usu, null);
        }
        [TestMethod]
        public void AñadirUsuarioTest()
        {
            AutentificacionXml xml = new AutentificacionXml("Usuarios.xml");
            IUsuarioView usu = new UsuarioView(25, "ddd", "ddd", "ddd", true);
            bool x = xml.InsertarUsuario(usu);

            Assert.IsTrue(x);
        }

        [TestMethod]
        public void EliminarUsuarioTest()
        {
            AutentificacionXml xml = new AutentificacionXml("Usuarios.xml");

            bool x = xml.EliminarUsuario("25");
            Assert.IsTrue(x);
        }

                [TestMethod]
        public void ModificarUsuarioTest()
        {
            AutentificacionXml xml = new AutentificacionXml("Usuarios.xml");
            IUsuarioView usu = new UsuarioView(150, "ddd", "ddd", "ddd", true);
            xml.InsertarUsuario(usu);
            usu = new UsuarioView(150, "aaa", "aaa", "aaa", true);
            bool x = xml.ModificarUsuario("150", usu);
            xml.EliminarUsuario("150");
            Assert.IsTrue(x);
        }

        [TestMethod]
        public void CompruebaAccesosConCodigoAutentificacionTest()
        {
            try
            {
              //  AutentificacionXml xml = new AutentificacionXml(@"C:\TFS\GINEBRA\2015-PSS-ALUMNOS\Subires Parra David (dsp086)\Grupo Trabajo\Practica_09\ImplementacionXML\Usuarios.xml");
                AutentificacionXml xml = new AutentificacionXml("Usuarios.xml");

                CodigoAutentificacion codigo = xml.EsUsuarioAutentificado("1", "PalabraPaso_1");
                Assert.IsTrue(codigo == CodigoAutentificacion.AccesoCorrecto);
                codigo = xml.EsUsuarioAutentificado("1", "PalabraPaso_3");
                Assert.IsTrue(codigo == CodigoAutentificacion.ErrorPalabraPaso || codigo == CodigoAutentificacion.AccesoInvalido);
            }
            catch (AutentificacionExcepcion)
            {
                Assert.IsFalse(true);
            }
        }

    }

}


