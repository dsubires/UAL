using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

using dsp086.Practica_02;
using System.Collections.Generic;


namespace dsp086.Practica_02
{
    [TestClass]
    public class TestListaGenericas
    {
        [TestMethod]
        public void Constructor_WithNoParameter_IsNotNull()
        {
            List<UsuarioView> lista = new List<UsuarioView>();
            Assert.IsNotNull(lista);
        }


        [TestMethod]

        public void Contains_AddedObject_IsTrue()
        {
            List<UsuarioView> lista = new List<UsuarioView>();
            UsuarioView user = new UsuarioView(1, "user-1", "pass-1", "alumno", true);
            lista.Add(user);
            bool existe = lista.Contains(user);
            Assert.IsTrue(existe);
        }

        [TestMethod]

        public void Contains_DifferentObjectWithSameId_IsTrue()
        {
            List<UsuarioView> lista = new List<UsuarioView>();
            UsuarioView user = new UsuarioView(1, "user-1", "pass-1", "alumno", true);
            lista.Add(user);
            UsuarioView userB = new UsuarioView(1, "user-1", "pass-1", "alumno", true);
            bool existe = lista.Contains(userB);
            Assert.IsTrue(existe);
        }

        [TestMethod]
        public void Sort_AddedObjects_LessIsTheFirst()
        {
            List<UsuarioView> lista = new List<UsuarioView>();
            UsuarioView user = new UsuarioView(2, "user-2", "pass-2", "alumno", true);
            lista.Add(user);
            UsuarioView userB = new UsuarioView(1, "user-1", "pass-1", "alumno", true);
            lista.Add(userB);

            UsuarioView userc = new UsuarioView(3, "user-3", "pass-1", "alumno", true);
            lista.Add(userc);
            UsuarioView user0 = new UsuarioView(0, "user-0", "pass-1", "alumno", true);
            lista.Add(user0);


            lista.Sort();
            bool iguales = lista[0] == user0;
            Assert.IsTrue(iguales);
        }
    }
}
