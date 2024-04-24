
    function submitForm()
    {
        // Ottieni i valori inseriti dall'utente
        const nome = document.getElementById("nome").value;
        const cognome = document.getElementById("cognome").value;
        const email = document.getElementById("email").value;
        const telefono = document.getElementById("telefono").value;
        const via = document.getElementById("via").value;
        const cap = document.getElementById("cap").value;
        const città = document.getElementById("città").value;
        const provincia = document.getElementById("provincia").value;

        const userData =
        {
            "nome": nome,
            "cognome": cognome,
            "mail": email,
            "telefono": telefono,
            "indirizzo":
            {
                "via": via,
                "cap": cap,
                "citta": città,
                "provincia": provincia
            }
        };

        // Invia i dati al backend tramite una richiesta POST
        fetch('http://localhost:8080/creaUtente',
        {
            method: 'POST',
            headers:
            {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        })
        .then(response =>
            {
            if (response.ok)
            {
                console.log('Dati inviati con successo al backend.');
            }
            else
            {
                console.error('Si è verificato un errore durante l\'invio dei dati al backend.');
            }
        })
        .catch(error =>
            {
            console.error('Si è verificato un errore:', error);
        });
    }
;
