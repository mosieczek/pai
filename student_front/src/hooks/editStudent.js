export const editStudent = (prop) => {
    console.log(prop)

    const {id, name, surname, avarage} = prop
    const baseUrl = `/update/${id}`
    fetch(baseUrl, 
        {
            method:'PUT',
            body:JSON.stringify({
                id: id,
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
