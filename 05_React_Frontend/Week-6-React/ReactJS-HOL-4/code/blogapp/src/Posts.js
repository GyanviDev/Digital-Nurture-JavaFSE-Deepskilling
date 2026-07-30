import React from "react";
import Post from "./Post";

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false
    };
  }

  // fetch posts from API and update the state
  loadPosts = () => {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then(response => response.json())
      .then(data => {
        // create Post instances for each
        const postObjs = data.map(
          item => new Post(item.id, item.title, item.body)
        );
        this.setState({ posts: postObjs });
      })
      .catch(error => {
        this.setState({ hasError: true });
        alert("Failed to load posts: " + error);
      });
  };

  // lifecycle: fetch posts after mount
  componentDidMount() {
    this.loadPosts();
  }

  // error boundary
  componentDidCatch(error, info) {
    this.setState({ hasError: true });
    alert("Component Error: " + error);
  }

  render() {
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }
    return (
      <div>
        <h1>Blog Posts</h1>
        {this.state.posts.map(post => (
          <div key={post.id} style={{ marginBottom: "24px" }}>
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
