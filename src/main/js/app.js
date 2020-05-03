//const React = require('react');
//const ReactDOM = require('react-dom');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {replays: []};
	}

//	componentDidMount() {
//		client({method: 'GET', path: '/findall'}).done(response => {
//			this.setState({replays: response.entity._embedded.replays});
//		});
//	}

	render() {
		return (
//			<ReplayList replays={this.state.replays}/>
            <h2>Hello World!</h2>
		)
	}
}