<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/padraotelacadastro.css">
        <script src="scripts/formatacampos.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>

        <style>
            body{
                font-family: Arial, Helv, sans-serif;
                background-image: linear-gradient(to right, rgb(9, 117, 167), rgb(9, 117, 167)); 
            }
            
            .box{
            color: white;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            background-color: rgba(0, 0, 0, 0.6);
            padding: 15px;
            border-radius: 15px;
            width: 25%;
        }
        fieldset{
            border: 3px solid dodgerblue;
            border-radius: 15px;
            padding-bottom: 25px;
        }

        legend{
            border: 1px solid dodgerblue;
            padding: 15px;
            text-align: center;
            background-color: dodgerblue;
            border-radius: 8px;
            top: 10%;
        }
        .inputBox{
            position: relative;
        }
        
                .inputUser{
            background: none;
            border: none;
            border-bottom: 1px solid white;
            outline: none;
            color: white;
            font-size: 15px;
            width: 100%;
            letter-spacing: 2px;
        }
        .labelInput{
            position: absolute;
            top: 0px;
            left: 0px;
            pointer-events: none;
            transition: .5s;
        }
        .inputUser:focus ~ .labelInput,
        .inputUser:valid ~ .labelInput{
            top: -20px;
            font-size: 12px;
            color: dodgerblue;
        }
        
        #submit{
            background-image: linear-gradient(to right,rgb(0, 92, 197), rgb(90, 20, 220));
            width: 100%;
            border: none;
            padding: 12px;
            color: white;
            font-size: 15px;
            cursor: pointer;
            border-radius: 10px;
        }
        </style>
 
    </head>
<body>
    <div class="box">
        <form action="">
            <fieldset>
                <legend><b>Cadastrar Nova Conta</b></legend>
                <br>
                <div class="inputBox">
                    <input type="text" name="nome" id="nome" class="inputUser" required>
                    <label for="nome" class="labelInput">Nome</label>
                </div>
                <br><br>
                <div class="inputBox">
                    <input type="text" name="sobrenome" id="sobrenome" class="inputUser" required>
                    <label for="sobrenome" class="labelInput">Sobrenome</label>
                </div>
                <br><br>                
                <div class="inputBox">
                    <input type="text" name="nmrconta" id="nmrconta" class="inputUser" required>
                    <label for="nmrconta" class="labelInput">Número da Conta</label>
                </div>
                <br><br>
                <div class="inputBox">
                    <input type="number" name="saldo" id="saldo" class="inputUser" required>
                    <label for="saldo" class="labelInput">Saldo</label>
                </div>
                <p><b>Tipo da Conta</b></p>
                <input type="radio" id="corrente" name="tipoconta" value="corrente" required>
                <label for="corrente">Corrente</label>
                <br>
                <input type="radio" id="poupanca" name="tipoconta" value="poupanca" required>
                <label for="poupanca">Poupan&ccedila</label>
                <br><br>
                <div class="inputBox">
                    <input type="text" name="instituicaofinanceira" id="instituicaofinanceira" class="inputUser" required>
                    <label for="instituicaofinanceira" class="labelInput">Institui&ccedil&atildeo Financeira</label>
                </div>
                <br>
                <input type="submit" name="submit" id="submit">
            </fieldset>
        </form>
    </div>
</body>
</html>
<script>
    
            function enviaForm(){
                document.forms[0].submit();
                response.sendRedirect("nulo.html");
            }
        </script>         
    </body>    
 </html>