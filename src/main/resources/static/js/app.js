var app = (function(){

    var buildTable = function(virus) {
        console.log(virus);
    }

    return {
        getCountry: function(name) {
            apiclient.getCountry(name,buildTable);
        }
    }
})();