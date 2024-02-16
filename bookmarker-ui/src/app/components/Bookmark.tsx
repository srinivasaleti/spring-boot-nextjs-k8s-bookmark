export interface IBookMark {
  createdAt: string;
  id: string;
  title: string;
  url: string;
}

export const BookMark = ({ bookmark }: { bookmark: IBookMark }) => {
  return (
    <div
      style={{
        border: "4px red",
        padding: "20px",
        boxShadow: "0px 1px 3px 1px #938d8d",
        cursor: "pointer",
      }}
    >
      <a
        style={{
          color: "black",
          fontWeight: 700,
          fontSize: "16px",
          textDecoration: "none",
        }}
        href={bookmark.url}
      >
        {bookmark.title}
      </a>
    </div>
  );
};
