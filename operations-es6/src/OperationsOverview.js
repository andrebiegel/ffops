export default class OperationsOverView extends HTMLElement {

    constructor(){
        super();
    }
    connectedCallback(){
        const customAttribute = this.getAttribute("info")
        this.innerHTML = `${customAttribute} <ul> </ul>`;

    }
    async retrieveInfo(){
       const request = await fetch ("http://localhost:8080/operations-managment/resources/operations");
       const payload = await request.json();
      // const (title, alarmtime) = payload;
    }

}
customElements.define("operations-overview",OperationsOverView );
