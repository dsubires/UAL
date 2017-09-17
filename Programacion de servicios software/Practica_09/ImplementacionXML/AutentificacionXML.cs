using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;
using System.IO;
using Principal;
using Exceptions;

namespace ImplementacionXML
{
    public class AutentificacionXml : IAutentificacion
    {
        private String _xmlFilename = "claves.xml";
        private XDocument _xmlDocument = null;

        /// <summary>
        /// Constructor en el que se especifica: nombre del archivo Xml que contiene los Usuario.
        /// </summary>
        /// <param name="xmlFile">nombre del archivo de Xml</param>

        public AutentificacionXml(string xmlFile)
        {
            _xmlFilename = xmlFile;

            if ((_xmlFilename != null) && File.Exists(_xmlFilename))
            {
                try
                {
                    _xmlDocument = XDocument.Load(_xmlFilename);
                }
                catch
                {
                    throw new AutentificacionExcepcion("Error al acceder al archivo Xml", CodigoAutentificacion.ErrorDatos);
                }
            }
            else throw new AutentificacionExcepcion("El fichero " + xmlFile + " no existe.", CodigoAutentificacion.ErrorDatos);
        }

        public CodigoAutentificacion EsUsuarioAutentificado(string id, string PalabraPaso)
        {
            if (_xmlDocument == null)
                return CodigoAutentificacion.ErrorDatos;
            IUsuarioView usuario = ObtenerUsuario(id);
            if (usuario == null)
                return CodigoAutentificacion.ErrorIdUsuario;
            else
            {
                if (usuario.PalabraPaso == PalabraPaso)
                {
                    if (usuario.EsValido)
                        return CodigoAutentificacion.AccesoCorrecto;
                    else
                        return CodigoAutentificacion.AccesoInvalido;
                }
                else
                {
                    if (usuario.EsValido)
                        return CodigoAutentificacion.ErrorPalabraPaso;
                    else
                        return CodigoAutentificacion.AccesoInvalido |
                                CodigoAutentificacion.ErrorPalabraPaso;
                }
            }
        }

        public bool ModificarUsuario(string id, IUsuarioView user)
        {
            var consulta = (from usuario in _xmlDocument.Elements("Usuarios").Elements("Usuario")
                            where usuario.Attribute("Id").Value.Equals(id)
                            select usuario).SingleOrDefault();
            if (consulta == null)
                return false;
            consulta.SetElementValue("Nombre", user.Nombre);
            consulta.SetElementValue("PalabraPaso", user.PalabraPaso);
            consulta.SetElementValue("Categoria", user.Categoria);
            consulta.SetElementValue("EsValido", user.EsValido);
            GuardarDatos();
            return true;
        }

        public bool InsertarUsuario(IUsuarioView user)
        {

            if (user.Id == null)
            {
                int id = (from user2 in _xmlDocument.Elements("Usuarios").Elements("Usuario")
                          orderby Convert.ToInt32(user2.Attribute("Id").Value)
                          select Convert.ToInt32(user2.Attribute("Id").Value)).Max();
                user.Id = "" + (id + 1);
            }
            else
            {
                if (ObtenerUsuario(user.Id) != null)
                    return false;
            }
            XElement ele = new XElement("Usuario",
                                        new XAttribute("Id", user.Id),
                                        new XElement("Nombre", user.Nombre),
                                        new XElement("Categoria", user.Categoria),
                                        new XElement("PalabraPaso", user.PalabraPaso),
                                        new XElement("EsValido", user.EsValido.ToString()));
            var usuarios = (from u in _xmlDocument.Elements("Usuarios")
                            select u).SingleOrDefault();
            usuarios.Add(ele);
            GuardarDatos();
            return true;
        }

        public bool EliminarUsuario(string id)
        {
            var consulta = (from usuario in _xmlDocument.Elements("Usuarios").Elements("Usuario")
                            where usuario.Attribute("Id").Value.Equals(id)
                            select usuario).SingleOrDefault();
            if (consulta == null)
                return false;
            consulta.Remove();
            GuardarDatos();
            return true;
        }

        public IUsuarioView ObtenerUsuario(string id)
        {

            var consulta = (from usuario in _xmlDocument.Elements("Usuarios").Elements("Usuario")
                            where usuario.Attribute("Id").Value.Equals(id)
                            select new UsuarioView
                            {
                                Id = usuario.Attribute("Id").Value,
                                Nombre = usuario.Element("Nombre").Value,
                                PalabraPaso = usuario.Element("PalabraPaso").Value,
                                Categoria = usuario.Element("Categoria").Value,
                                EsValido = Convert.ToBoolean(usuario.Element("EsValido").Value)
                            }).SingleOrDefault();
            return consulta;
        }

        public void GuardarDatos()
        {
            _xmlDocument.Save(_xmlFilename);
        }
    }
}