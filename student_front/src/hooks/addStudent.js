export const addStudent = (prop) => {
    const baseUrl = '/students/add'

    const {name, surname, avarage} = prop

    console.log(name, surname, avarage)
    fetch(baseUrl, 
        {
            method:'POST',
            body:JSON.stringify({
                name: name,
                surname: surname,
                avarage: avarage
            }),
            headers: { "content-type":'application/json'}
        })
        .then((response) => {
            const result = response.data;
            console.log(result)
        });

    

}
