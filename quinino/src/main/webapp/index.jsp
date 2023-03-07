<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Q.uinino</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
         <link rel="stylesheet" type="text/css" href="Style.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous">  
        </script>
       
    </head>
    <body>
    <form id="form"  method="post" action="${pageContext.request.contextPath}/PlanController">
        <div id="main">
            <div class="row">
                <div class="col-md-12">
                    <h2>Q.uinino - FaleMais</h2>
                </div>
            </div>
               
            <div class="row" id="secaoCodigo"> 
                <div class="col-md-6">
                    <label for="txtOrigin"> Codigo Origem</label>
                    <input  class="form-control" type="text" id="txtOrigin" value="${valueOrigin}"  name="txtOrigin" oninput="validateField(this)" maxlength="3">
                </div>
                <div class="col-md-6">
                    <label for="txtDestiny"> Codigo destino</label>
                    <input  class="form-control" type="text" id="txtDestiny"  value="${valueDestination}"  name="txtDestiny" oninput="validateField(this)" maxlength="3">
                </div>
            </div>
            
            <div class="row" id="secaoTempoPlano">
                <div class="col-md-6">
                    <label for="txtTime"> Tempo em minutos :</label>                                                            
                    <input  class="form-control" type="text" id="txtTime" value="${valueTimeMinutes}"   name="txtTime" oninput="validateInput(this)" maxlength="6">
                </div>
                <div class="col-md-6">
                    <label for="slctPlan">Plano FaleMais</label>
                    <select class="form-control" id="slctPlan" name="slctPlan">
                        <option  ${plan == '30' ? 'selected' : ''}  value="30">FaleMais 30</option>
                        <option ${plan == '60' ? 'selected' : ''}  value="60">FaleMais 60</option>
                        <option ${plan == '120' ? 'selected' : ''}  value="120">FaleMais 120</option>
                    </select>
                </div>
            </div>
            
            <div class="row" id="containerBtn">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-outline-dark"">Calcular</button>
                </div>
            </div>
            
          
               <div class="row"  id="containerResuFaleMais">
                  <div class="col-md-12" >
                   	    <label for="txtResultFaleMais"> Valor com o plano faleMais :</label>
               			<input value="${priceWithPlan}"  disabled class="form-control" type="text" id="txtResultFaleMais">
                  </div> 
               </div>
               
                <div class="row"  id="containerResultNoPlan">
                  <div class="col-md-12" >
                   	    <label for="txtResultNoPlan"> Valor Sem o Plano :</label>
               			<input value="${priceWithoutPlan}" disabled class="form-control" type="text" id="txtResultNoPlan">
                  </div> 
               </div>
               
        </div>
      </form>  
    </body>
    
   <script>
  
   
    		function validateField(campo) {
      		campo.value = campo.value.replace(/\D/g, '').substring(0,3);
    		}
    		
    		function validateInput(input) {
    			  var regex = /^[0-9]*\.?[0-9]*$/;
    			  if (!regex.test(input.value)) {
    			    input.value = input.value.replace(/[^0-9\.]/g, "");
    			  }
    			} 
  </script>
</html>

