function changeRegions(countryId) {
Liferay.Service(
		  '/region/get-regions',
		  {
		    countryId: countryId
		  },
		  function(obj) {
		    console.log(obj);
		    $(".regionSelect").empty();
			$(".regionSelect").append("<option value='0'>请选择</option>");
			for (var i=0; i<obj.length; i++) {
				var region = obj[i];
				$(".regionSelect").append("<option value='" + region.regionId + "'>" + region.name + "</option>");
			}
		  }
		);
}