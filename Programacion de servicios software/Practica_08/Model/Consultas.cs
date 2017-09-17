using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_08
{
    public class Consultas
    {
        UserData Datos;
        public Consultas()
        {
            Datos = new UserData();
            Datos.CargarDatos();
        }

        //**************  Usuarios ********************************
        /// <summary>
        /// Usuarios que se han conectado a una aplicación según la categoria cuyo codigo es categoriaId
        /// </summary>
        /// <param name="categoriaId"> Id de la categoria</param>
        /// <returns> Lista ordenada alfabéticamente de los nombres de ls usuarios en mayúsculas</returns>
        public IEnumerable<vmNombre> UsuariosEnCategoria(int categoriaId)
        {
            var resultado = from usu in Datos.Usuarios
                            join usucat in Datos.UsuariosCategorias
                                on usu.Id equals usucat.UsuarioId
                            where usucat.CategoriaId == categoriaId
                            orderby usu.NombreUsuario
                            select new vmNombre { Nombre = usu.NombreUsuario.ToUpper() };
            return resultado;
        }

        /// <summary>
        /// Usuarios que se han conectado a una aplicación según la categoria cuyo nombre es nombreCategoria
        /// </summary>
        /// <param name="nombreCategoria"> Nombre de la categoria</param>
        /// <returns> Lista ordenada alfabéticamente de los nombres de ls usuarios en mayúsculas</returns>
        public IEnumerable<vmNombre> UsuariosEnCategoria(string nombreCategoria)
        {
            var resultado = from usu in Datos.Usuarios
                            join usucat in Datos.UsuariosCategorias
                                on usu.Id equals usucat.UsuarioId
                            join cat in Datos.Categorias
                                on usucat.CategoriaId equals cat.Id
                            where cat.NombreCategoria == nombreCategoria
                            orderby usu.NombreUsuario
                            select new vmNombre { Nombre = usu.NombreUsuario.ToUpper() };
            return resultado;
        }

        /// <summary>
        /// Usuarios cuyo nombre comienza por cadenaComienzo 
        /// </summary>
        /// <param name="cadenaComienzo">cadena de comienzo del nombre</param>
        /// <returns> Lista de los nombres de ls usuarios en mayúsculas</returns>
        public IEnumerable<vmNombre> UsuariosConNombreComienza(string cadenaComienzo)
        {
            var resultado = from usu in Datos.Usuarios
                            where usu.NombreUsuario.StartsWith(cadenaComienzo)
                            orderby usu.NombreUsuario
                            select new vmNombre { Nombre = usu.NombreUsuario.ToUpper() };
            return resultado;
        }

        /// <summary>
        /// Usuarios cuyo nombre comienza por cadenaComienzo que pertenecen a una categoria dada
        /// </summary>
        /// <param name="categoria">nombre de la caegoria</param>
        /// <param name="cadenaComienzo">cadnea de comienzo del nombre</param>
        /// <returns> Lista ordenada alfabéticamente de los nombres de ls usuarios en mayúsculas</returns>
        public IEnumerable<vmNombre> UsuariosConNombreComienzaEnCategoria
                (string cadenaComienzo, string categoria)
        {
            var resultado = from usu in Datos.Usuarios
                            join usucat in Datos.UsuariosCategorias
                                on usu.Id equals usucat.UsuarioId
                            join cat in Datos.Categorias
                                on usucat.CategoriaId equals cat.Id
                            where cat.NombreCategoria == categoria
                                && usu.NombreUsuario.StartsWith(cadenaComienzo)
                            orderby usu.NombreUsuario
                            select new vmNombre { Nombre = usu.NombreUsuario.ToUpper() };
            return resultado;
        }

        /// <summary>
        /// Usuarios conectados desde una IP  
        /// </summary>
        /// <param name="ip">ip de la conexion</param>
        /// <returns> Lista de los nombres de los usuarios en mayúsculas</returns>
        public IEnumerable<vmNombre> UsuariosConectadosIP(string ip)
        {
            var resultado = (from usu in Datos.Usuarios
                             join usucat in Datos.UsuariosCategorias
                                 on usu.Id equals usucat.UsuarioId
                             join con in Datos.Conexiones
                                 on usucat.Id equals con.UsuarioCategoriaId
                             where con.IP == ip
                             orderby usu.NombreUsuario
                             select new vmNombre { Nombre = usu.NombreUsuario.ToUpper() }).Distinct();
            return resultado;
        }

        /// <summary>
        /// Encuentra el  nombre del usuario de una aplicación dada a través de su e-mail
        /// </summary>
        /// <param name="Aplicacion"> cadena con el nombre de la aplicación</param>
        /// <param name="email">cadena con el e-mail</param>
        /// <returns> Nombre del Usuario o null si no se encuentra</returns>
        public IEnumerable<vmNombre> EncontrarUsuarioAppEmail(string aplicacion,
                    string email)
        {
            var resultado2 = (from apl in Datos.Aplicaciones
                             join per in Datos.Personales
                                 on apl.Id equals per.AplicacionId
                             join usu in Datos.Usuarios
                                 on per.UsuarioId equals usu.Id
                             where apl.NombreAplicacion == aplicacion
                                 && per.Email == email
                             orderby usu.NombreUsuario
                             select usu.NombreUsuario.ToUpper()).Distinct();
            var resultado = from s in resultado2
                                select new vmNombre { Nombre = s };
            return resultado;
        }


        //**********   Categorias ***************

        /// <summary>
        /// Lista de pares (Categoria,Usuario) para  una aplicación dada
        /// </summary>

        /// <param name="aplicación">nombre de la aplicación</param>
        /// <returns>Lista de pares (nombre de categoria y nombre de Usuario)</returns>
        public IEnumerable<vmCategoriaNombre> ListaParCategoriaUsuarioParaApp(string aplicacion)
        {
            var resultado = (from apl in Datos.Aplicaciones
                             join usu in Datos.Usuarios
                                 on apl.Id equals usu.AplicacionId
                             join cat in Datos.Categorias
                                 on apl.Id equals cat.AplicacionId
                             where apl.NombreAplicacion == aplicacion
                             //                            orderby apl.NombreAplicacion
                             orderby cat.NombreCategoria ascending
                             select new vmCategoriaNombre
                             {
                                 Categoria = cat.NombreCategoria,
                                 Nombre = usu.NombreUsuario
                             }).Distinct();
            return resultado;
        }

        /// <summary>
        /// Lista de Usuarios agrupados en lista de categorias  (un mismo usuario puede estar en dos categorias)
        /// </summary>
        /// <returns> Lista  de nombres de usuario agrupados para cada categoria (de otra lista)  </returns>
        public IEnumerable<IGrouping<string, vmCategoriaNombre>> AgrupacionUsuariosCategorias()
        {
            var resultado = from usu in Datos.Usuarios
                            join usucat in Datos.UsuariosCategorias
                                on usu.Id equals usucat.UsuarioId
                            join cat in Datos.Categorias
                                on usucat.CategoriaId equals cat.Id
                            orderby cat.NombreCategoria ascending
                            group new vmCategoriaNombre
                            {
                                Categoria = cat.NombreCategoria,
                                Nombre = usu.NombreUsuario
                            }
                            by cat.NombreCategoria;
            return resultado;
        }

        /// <summary>
        /// Relacion de Usuarios agrupados en categorias ordenadas éstas en orden descendente alfabéticamente 
        ///(un mismo puede aparecer  varias veces si esta en varias categorias)
        /// </summary>
        /// <returns> Lista agrupada de usuarios por categorias </returns>
        public IEnumerable<vmCategoriaNombre> AgrupacionUsuariosCategoriasOrdenadas()
        {
            var resultado = from usu in Datos.Usuarios
                            join usucat in Datos.UsuariosCategorias
                                on usu.Id equals usucat.UsuarioId
                            join cat in Datos.Categorias
                                on usucat.CategoriaId equals cat.Id
                            orderby cat.NombreCategoria descending
                            select new vmCategoriaNombre
                            {
                                Categoria = cat.NombreCategoria,
                                Nombre = usu.NombreUsuario
                            };
            return resultado;
        }



        /// <summary>
        /// Categoria con mayor numero de usuarios y total 
        /// </summary>
        /// <returns>Devuelve nombre de la categoria con más usurios y el numero de usuarios</returns>
        public IEnumerable<vmCategoriaNombre> CategoriaMaximoNumeroUsuarios() //CategoriaConMayorNumeroUsuariosConectados()
        {
            var resultado = (from cat in Datos.Categorias
                             join usucat in Datos.UsuariosCategorias
                                 on cat.Id equals usucat.CategoriaId
                             join usu in Datos.Usuarios
                                 on usucat.UsuarioId equals usu.Id
                             group usu.Id by cat.NombreCategoria into g
                             orderby g.Count() descending
                             select new vmCategoriaNombre
                             {
                                 Categoria = g.Key,
                                 Nombre = g.Count().ToString()
                             }).Take(1);
            return resultado;
        }



        /// <summary>
        /// Todas las categorias de usuarios para una aplicación dada
        /// </summary>
        /// <param name="aplicacion"> nombre de la aplicación</param>
        /// <returns>Lista de los nombres de las categorias de usuarios</returns>
        public IEnumerable<vmCategoriaNombre> TodasCategoriasApp(string aplicacion)
        {
            var resultado = from apl in Datos.Aplicaciones
                            join cat in Datos.Categorias
                                on apl.Id equals cat.AplicacionId
                            where apl.NombreAplicacion == aplicacion
                            orderby cat.NombreCategoria ascending
                            select new vmCategoriaNombre
                            {
                                Categoria = cat.NombreCategoria,
                                Nombre = apl.NombreAplicacion
                            };
            return resultado;
        }



        /// <summary>
        /// Lista de Categoria/Aplicación  para un usuario dado 
        /// </summary>
        /// <param name="usuario">nombre del usuario</param>
        /// <returns>Lista de pares (nombre de categoria y nombre de aplicación)</returns>
        public IEnumerable<vmCategoriaNombre> CategoriasAplicacionParaUsuario(string usuario)
        {
            var resultado = from apl in Datos.Aplicaciones
                            join cat in Datos.Categorias
                                on apl.Id equals cat.AplicacionId
                            join usu in Datos.Usuarios
                                on apl.Id equals usu.AplicacionId
                            where usu.NombreUsuario == usuario
                            orderby cat.NombreCategoria ascending
                            select new vmCategoriaNombre
                            {
                                Categoria = cat.NombreCategoria,
                                Nombre = apl.NombreAplicacion
                            };
            return resultado;
        }


        //********************* agrupaciones ********************
        /// <summary>
        /// ¿Desde que IP ha habido más conexiones y cuantas para una categoria dada? 
        /// </summary>
        /// <returns>Lista con la IP y el número de conexiones</returns>
        public IEnumerable<vmNombreCantidad> IPconMasConexionesSegunCategoria(string nombreCategoria)
        {
            var resultado = (from cat in Datos.Categorias
                             join usucat in Datos.UsuariosCategorias
                                 on cat.Id equals usucat.CategoriaId
                             join con in Datos.Conexiones
                                 on usucat.Id equals con.UsuarioCategoriaId
                             where cat.NombreCategoria == nombreCategoria
                             group con.Id by con.IP into g
                             orderby g.Count() descending
                             select new vmNombreCantidad
                             {
                                 Nombre = g.Key,
                                 Cantidad = g.Count()
                             }).Take(1);
            return resultado;
        }



        /// <summary>
        /// Secuencia de pares (usuarios, suma total duración de conexion) ordenados de mayor a menor duración
        /// </summary>

        /// <returns>Lista de pares NombreUsuario, suma de la duración de las conexiones</returns>
        public IEnumerable<vmNombreCantidad> UsuarioSumaDuracionConexiones()
        {
            var resultado = from usu in Datos.Usuarios
                            join usucat in Datos.UsuariosCategorias
                                on usu.Id equals usucat.UsuarioId
                            join con in Datos.Conexiones
                                on usucat.Id equals con.UsuarioCategoriaId
                            group con.Duracion by usu into g
                            orderby g.Sum() descending
                            select new vmNombreCantidad
                            {
                                Nombre = g.Key.NombreUsuario,
                                Cantidad = (double?)g.Sum() ?? 0
                            };
            return resultado;
        }





        /// <summary>
        /// LEFT OUTER JOIN
        /// Secuencia de pares (usuarios, suma total de duración de conexiones) ordenados de menor a mayor duración 
        /// Usuarios que no se hayan conectado nunca deberán aparecer con una cantidad de 0
        /// </summary>

        /// <returns>Lista de pares NombreUsuario, total suma de duración de conexiones</returns>
        public IEnumerable<vmNombreCantidad> UsuarioSumaDuracionConexionesNulos()
        {
            var subconsulta = from usu in Datos.Usuarios
                              join usucat in Datos.UsuariosCategorias
                                   on usu.Id equals usucat.UsuarioId
                              join con in Datos.Conexiones
                                   on usucat.Id equals con.UsuarioCategoriaId into conex
                              from x in conex.DefaultIfEmpty(null)
                              select new vmNombreCantidad
                              {
                                  Nombre = usu.Id.ToString(),
                                  Cantidad = (x == null) ? 0 : x.Duracion // si es nulo, pongo 0
                              };
            var resultado = from x in subconsulta
                           join usu in Datos.Usuarios
                                on x.Nombre equals usu.Id.ToString()
                           group x.Cantidad by usu into g
                           orderby g.Sum()
                           select new vmNombreCantidad
                           {
                               Nombre = g.Key.NombreUsuario,
                               Cantidad = ((double?)g.Sum() ?? 0)
                           };
            return resultado;
        }




        /// <summary>
        /// LEFT OUTER JOIN
        /// Relacion de usuarios cuya suma total de duración de conexión sea superior a la media. 
        /// </summary>
        /// <returns>Lista con el nombre de usuario y suma total de duracion de conexiones</returns>
        public IEnumerable<vmNombreCantidad> UsuariosSumaDuracionMayorMedia()
        {
            var resultado = (from usu in Datos.Usuarios
                             join usuCateg in Datos.UsuariosCategorias
                                  on usu.Id equals usuCateg.UsuarioId
                             join conex in Datos.Conexiones
                                 on usuCateg.Id equals conex.UsuarioCategoriaId

                             group new { usu, conex } by usu.NombreUsuario
                                 into grUsu
                                 let media = Datos.Conexiones.Average(med => (double?)med.Duracion ?? 0)
                                 orderby grUsu.Sum(cant => cant.conex.Duracion)
                                 select new vmNombreCantidad
                                 {
                                     Nombre = grUsu.Key,
                                     Cantidad = grUsu.Sum(conex => (double?)conex.conex.Duracion ?? 0)
                                 }
                          );
            return resultado;
        }


        /// <summary>
        /// Relacion de aplicaciones y su respectiva suma de tiempos de conexi?n de todos los usuarios 
        /// </summary>
        /// <returns>Lista con el nombre de aplicacion y  suma total de duracion de conexiones</returns>
        public IEnumerable<vmNombreCantidad> AplicacionesMasUsadas()
        {
            var consulta = (from app in Datos.Aplicaciones
                            join user in Datos.Usuarios on app.Id equals user.AplicacionId
                            join userCat in Datos.UsuariosCategorias on user.Id equals userCat.UsuarioId
                            join cat in Datos.Categorias on app.Id equals cat.AplicacionId
                            join con in Datos.Conexiones on userCat.Id equals con.UsuarioCategoriaId
                            group new { app, con } by app.NombreAplicacion into groupp
                            select new vmNombreCantidad { Nombre = groupp.Key, Cantidad = groupp.Sum(c => (double?)c.con.Duracion ?? 0) }).OrderBy(reg => reg.Nombre);
            return consulta;
        }

        /// <summary>
        /// Relacion de aplicaciones y su respectiva suma de tiempos de conexi?n de todos los usuarios (ordenas de mayor a menor) 
        /// </summary>
        /// <returns>Lista con el nombre de aplicacion y  suma total de duracion de conexiones</returns>
        public IEnumerable<vmNombreCantidad> AplicacionesMasUsadasOrdenadas()
        {
            var consulta = (from app in Datos.Aplicaciones
                            join user in Datos.Usuarios on app.Id equals user.AplicacionId
                            join userCat in Datos.UsuariosCategorias on user.Id equals userCat.UsuarioId
                            join cat in Datos.Categorias on app.Id equals cat.AplicacionId
                            join con in Datos.Conexiones on userCat.Id equals con.UsuarioCategoriaId
                            group new { app, con } by app.NombreAplicacion into groupp
                            orderby groupp.Sum(c => (double?)c.con.Duracion ?? 0) descending
                            select new vmNombreCantidad { Nombre = groupp.Key, Cantidad = groupp.Sum(c => (double?)c.con.Duracion ?? 0) });
            return consulta;
        }


    }
}
