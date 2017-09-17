using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

using dsp086.Practica_02;
using System.Collections.Generic;

namespace dsp086.Practica_02
{
    [TestClass]
    public class TestDictionary
    {
        [TestMethod]
        public void Constructor_WithNoParams_IsNotNull()
        {
            Dictionary<UsuarioView, string> dic = new Dictionary<UsuarioView, string>();
            Assert.IsNotNull(dic);
        }

        [TestMethod]
        public void Accessing_AnAddedObject_IsNotNull()
        {
            Dictionary<UsuarioView, string> dic = new Dictionary<UsuarioView, string>();
            UsuarioView user = new UsuarioView(1, "user-1", "pass-1", "alumno", true);
            dic.Add(user, "1");
            Assert.IsNotNull(dic[user]);
        }

        [TestMethod]
        public void Contanins_AnAddedObject_IsTrue()
        {
            Dictionary<UsuarioView, string> dic = new Dictionary<UsuarioView, string>();
            UsuarioView user = new UsuarioView(1, "user-1", "pass-1", "alumno", true);
            dic.Add(user, "1");
            bool existe = dic.ContainsKey(user);
            Assert.IsTrue(existe);
        }

        [TestMethod]
        public void Contanins_DifferentObjectWithSameId_IsTrue()
        {
            Dictionary<UsuarioView, string> dic = new Dictionary<UsuarioView, string>();
            UsuarioView user = new UsuarioView(1, "user-1", "pass-1", "alumno", true);
            dic.Add(user, "1");
            UsuarioView userB = new UsuarioView(1, "user-1", "pass-1", "alumno", true);
            bool existe = dic.ContainsKey(userB);
            Assert.IsTrue(existe);
        }
    }
}
