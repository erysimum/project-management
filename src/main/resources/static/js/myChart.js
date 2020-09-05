
var chartDataStr= decodeHtml(chartData);
var jsonArray = JSON.parse(chartDataStr);

var numericData = [];
var labelData = [];

for(var i=0;i<jsonArray.length;i++){
	numericData[i] = jsonArray[i].value;
	labelData[i] = jsonArray[i].label;
}


var ctx = document.getElementById("myPieChart");
var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'pie',

    // The data for our dataset
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
            borderColor: 'rgb(255, 99, 132)',
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
    	title:{
    		display:true,
    		text:'Project Status'
    	}
    }
});

function decodeHtml(html){
	var txt=document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}