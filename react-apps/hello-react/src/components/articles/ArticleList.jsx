/** @format */

const ArticleList = ({ articleData }) => {
    console.log("ArticleList");
    console.log(articleData);
    if (!articleData) {
        return (
            <>
                <td>
                    Loading ...
                </td>
            </>
        );
    }
    return (
        <>
            {articleData.result.map((article) => (
                <tr key={article.id}>
                    <td>{article.id}</td>
                    <td>{article.subject}</td>
                    <td>{article.membersVO.name}</td>
                    {/* <td>{article.membersVO.name}({article.email})</td> */}
                    <td>{article.viewCnt}</td>
                    <td>{article.crtDt}</td>
                </tr>
            ))}
        </>
    );
};
export default ArticleList;