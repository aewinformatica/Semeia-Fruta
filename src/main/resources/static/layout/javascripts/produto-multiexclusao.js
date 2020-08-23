var Semeia = Semeia || {};

Semeia.MultiExclusao = (function() {
	
	function MultiExclusao() {
		this.excluirEmMassaBtn = $('.js-excluir-em-massa-btn');
		this.selecaoCheckbox = $('.js-selecao');
		this.selecaoTodosCheckbox = $('.js-selecao-todos');
	}
	
	MultiExclusao.prototype.iniciar = function() {
		this.excluirEmMassaBtn.on('click', onexcluirEmMassaBtnClicado.bind(this));
		this.selecaoTodosCheckbox.on('click',onSelecaoTodosClicado.bind(this));
		this.selecaoCheckbox.on('click',onSelecaoClicado.bind(this));
	}
	
	function onexcluirEmMassaBtnClicado(event) {
		var botaoClicado = $(event.currentTarget);
		
		var url = botaoClicado.data('url');
		
		var checkboxSelecionados = this.selecaoCheckbox.filter(':checked');
		var codigos = $.map(checkboxSelecionados, function(c) {
			return $(c).data('codigo');
		});
		
		if (codigos.length > 0) {
			$.ajax({
				url: url,
				method: 'GET',
				data: {
					codigos: codigos
				}, 
				success: function() {
					window.location.reload();
				}
			});
			
		}
	}
	
	function onSelecaoTodosClicado(){
		//pega o valor do checkbox passa para uma variavel 
		var status = this.selecaoTodosCheckbox.prop('checked');
		
		this.selecaoCheckbox.prop('checked',status);
		console.log(status);
	}
	function onSelecaoClicado(){
		
//		usando filtro para saber quantos estao = checked
		var selecaoCheckboxChecados = this.selecaoCheckbox.filter(':checked');
		
//		setando a propriedade passando um if dentro da funcao
		this.selecaoTodosCheckbox.prop('checked', selecaoCheckboxChecados.length >= this.selecaoCheckbox.length)
	}
	
	return MultiExclusao;
	
}());

$(function() {
	var MultiExclusao = new Semeia.MultiExclusao();
	MultiExclusao.iniciar();
});