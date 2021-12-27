export const deleteStudent = (prop) => {

    const baseUrl = `/delete/${prop}`
    console.log(prop, baseUrl)
    fetch(baseUrl, 
        {
            method:'DELETE',
            headers: { "content-type":'application/json'}
        })
        .then((response) => {
            const result = response.data;
            console.log(result)
        });
}
