angular.module('MiniCursoApp', [])
   .controller('MiniCursoController', function($scope, $http) {
       $scope.atualizarCursos = function(){
    	   $http.get("rest/curso").success(function(cursos){
    		  $scope.cursos = cursos;
    	   });
       }
       $scope.atualizarCursos();
       // maneira boba de fazer isso - mas õtima para testar
       $scope.verificaAdm = function() {
    	   $http.get("rest/admin").success(function(){
     		  $scope.ehAdmin = true;
     		  alert("Entrou como ADMIN!")
     	   }).error(function(){
     		   alert("Você não é admin!");
     	   });
       }
       
       $scope.seleciona = function(c){
    	   $scope.selecionado = c;
       }
});

//
//
//
//
//
//
//
//
//
//var dados = [];
//var selecionado = null;
//
//function enviaProduto() {
//	var metodo = "POST";
//	var p = { nome : $("#nome").val(), preco : Number($("#preco").val()), quantidade : Number($("#quantidade").val()) };
//	if(selecionado) {
//		p.id = selecionado.id;
//		metodo = "PUT";
//	}
//	$.ajax({ method : metodo, contentType : "application/json", url : "rest/produto", data : JSON.stringify(p)
//	}).done(carregar);
//}
//
//function apagar(id) {
//	$.ajax({ method : "DELETE", contentType : "application/json", url : "rest/produto/" + id
//	}).done(carregar);
////}
//
//function carregar() {
//	var prodHtml = [];
//	$.getJSON("rest/produto", function(produtos) {
//		dados = produtos;
//		$.each(produtos, function(i, p) {
//			prodHtml.push("<tr onclick='seleciona(" + i + ")'>");
//			prodHtml.push("<td>" + p.id + "</td><td>" + p.nome + "</td><td>"
//					+ p.preco + "</td><td>" + p.quantidade + "</td>");
//			prodHtml.push("<td><button onclick='apagar(" + p.id
//					+ ")'>X</button></td>");
//			prodHtml.push("</tr>");
//		});
//		$("#tblProdutos").html(prodHtml.join());
//		limparSelecionado();
//	});
//}
//
//function seleciona(i) {
//	selecionado = dados[i];
//	$("#tituloForm").text("Editar")
//	$("#nome").val(selecionado.nome);
//	$("#preco").val(selecionado.preco);
//	$("#quantidade").val(selecionado.quantidade);
//}
//
//function limparSelecionado() {
//	selecionado = null;
//	$("#campos input[type=text]").val("");
//}
//carregar();